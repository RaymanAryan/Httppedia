//package com.rayman.httppedia.userinterface.navigation
//
//import androidx.compose.material3
//import androidx.compose.material3
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.navigation.NavController
//import androidx.navigation.compose.currentBackStackEntryAsState
//
//@Composable
//fun BottomNavBar(navController: NavController, items: List<BottomNavItem>) {
//    BottomNavigation {
//        val navBackStackEntry = navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry.value?.destination?.route
//
//        items.forEach { item ->
//            BottomNavigationItem(
//                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
//                label = { Text(item.label) },
//                selected = currentRoute == item.route,
//                onClick = { navController.navigate(item.route) }
//            )
//        }
//    }
//}
//
//data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)
