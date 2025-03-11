package com.rayman.httppedia.user_interface.screens.data_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rayman.httppedia.data.model.ApiData
import com.rayman.httppedia.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    private val _data = MutableStateFlow<List<ApiData>>(emptyList()) // Ensure List<ApiData>
    val data: StateFlow<List<ApiData>> = _data.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val items = repository.loadJsonFromAssets() // Check what it returns
            _data.value = items?.let { listOf(it) } ?: emptyList() // Convert to List
        }
    }
}


