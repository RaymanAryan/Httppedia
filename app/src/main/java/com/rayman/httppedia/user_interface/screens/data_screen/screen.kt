package com.rayman.httppedia.user_interface.screens.data_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreen(screens: Screens = Screens()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Httppedia") })
        },
        bottomBar = {
            BottomAppBar {
                SingleChoiceSegmentedButton()
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            ExpandableHttpList()
        }
    }
}

@Preview
@Composable
fun DataScreenPriview(){
    DataScreen()
}
