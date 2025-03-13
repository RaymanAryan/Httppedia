package com.rayman.httppedia.user_interface.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rayman.httppedia.user_interface.screens.data_screen.DataScreen
import com.rayman.httppedia.user_interface.screens.data_screen.Screens
import com.rayman.httppedia.user_interface.screens.settengs_screen.SettingsScreen

@Composable
fun NavGraph(navController: NavHostController,screens: Screens = Screens()) {
    NavHost(navController = navController, startDestination = "data") {
        composable("data") { DataScreen(navController, screens = screens) }
        composable("settings") { SettingsScreen() }
    }
}



