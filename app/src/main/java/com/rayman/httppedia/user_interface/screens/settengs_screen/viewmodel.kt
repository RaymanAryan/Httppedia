package com.rayman.httppedia.user_interface.screens.settengs_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rayman.httppedia.data.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repository: SettingsRepository) : ViewModel() {

    val themeState = repository.themeFlow
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    val usernameState = repository.usernameFlow
        .stateIn(viewModelScope, SharingStarted.Lazily, "")

    fun saveTheme(isDark: Boolean) = viewModelScope.launch {
        repository.saveThemePreference(isDark)
    }
    fun saveUsername(name: String) = viewModelScope.launch {
        repository.saveUsername(name)
    }
}

