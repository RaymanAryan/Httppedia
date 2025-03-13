package com.rayman.httppedia.user_interface.screens.data_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreen(navController: NavHostController,screens: Screens = Screens()) {
    Scaffold(
        topBar = {MyTopAppBar(navController)},
        bottomBar = {
            BottomAppBar {
                SingleChoiceSegmentedButton(screens = screens)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            ExpandableHttpList(screens = screens)
        }
    }
}

