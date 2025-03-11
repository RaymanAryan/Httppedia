package com.rayman.httppedia.user_interface.screens.data_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableHttpList(
    viewModel: DataViewModel = hiltViewModel(),
    screens: Screens = remember { Screens() }
) {
    val items by viewModel.data.collectAsState()

    val exceptionList by rememberSaveable {
        mutableStateOf(items.flatMap { item -> item.http_exceptions })
    }

    val methodList by rememberSaveable {
        mutableStateOf(items.flatMap { item -> item.http_methods })
    }

    // Display the list only if the current screen is Errors.
    if (screens.currentScreen == DataScreen.Errors) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(exceptionList) { item ->
                ExpandableHttpCard(
                    title = item.title,
                    headline = item.headline,
                    description = item.description
                )
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(methodList) { item ->
                ExpandableHttpCard(
                    title = item.title,
                    headline = item.headline,
                    description = item.description
                )
            }
        }
        // Handle other screens (e.g., DataScreen.Ret) accordingly.
    }
}


enum class DataScreen {
    Errors,
    Ret
}

class Screens {
    var currentScreen: DataScreen by mutableStateOf(DataScreen.Errors)
}

@Preview
@Composable
fun ExpandableHttpListPreview() {
    ExpandableHttpList()
}