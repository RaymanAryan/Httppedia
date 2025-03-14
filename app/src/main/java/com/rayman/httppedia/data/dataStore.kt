package com.rayman.httppedia.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


class SettingsRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {
    private object PreferencesKeys {
        val DARK_MODE = booleanPreferencesKey("dark_mode")
        val USERNAME = stringPreferencesKey("username")
    }

    val themeFlow: Flow<Boolean> = dataStore.data.map { it[PreferencesKeys.DARK_MODE] ?: true }
    val usernameFlow: Flow<String> = dataStore.data.map { it[PreferencesKeys.USERNAME] ?: "User" }

    suspend fun saveThemePreference(isDarkMode: Boolean) {
        dataStore.edit { it[PreferencesKeys.DARK_MODE] = isDarkMode }
    }


    suspend fun saveUsername(name: String) {
        dataStore.edit { it[PreferencesKeys.USERNAME] = name }
    }
}
