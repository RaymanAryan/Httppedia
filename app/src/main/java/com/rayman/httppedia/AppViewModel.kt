package com.rayman.httppedia

import androidx.lifecycle.ViewModel
import com.rayman.httppedia.user_interface.screens.data_screen.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(screens: Screens): ViewModel(){
    private val _myScreen = MutableStateFlow<Screens>(screens) // Ensure List<ApiData>
    val myScreen: StateFlow<Screens> = _myScreen.asStateFlow()
}