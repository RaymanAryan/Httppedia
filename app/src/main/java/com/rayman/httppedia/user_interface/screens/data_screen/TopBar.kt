package com.rayman.httppedia.user_interface.screens.data_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavHostController) {
    TopAppBar(
        title = { Text("HTTPPedia") },
        actions = {
            IconButton(onClick = { navController.navigate("settings") }) { // Navigate to settings
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    )
}

