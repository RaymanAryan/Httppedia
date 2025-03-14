package com.rayman.httppedia.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences> // Using Hilt-provided DataStore
) {
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