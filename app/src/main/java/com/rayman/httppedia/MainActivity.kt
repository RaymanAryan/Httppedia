package com.rayman.httppedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.rayman.httppedia.ui.theme.HttppediaTheme
import com.rayman.httppedia.user_interface.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HttppediaTheme {
                HTTPPediaApp()
            }
        }
    }
}

@Composable
fun HTTPPediaApp(viewModel: AppViewModel = hiltViewModel()) {
    val screens by viewModel.myScreen.collectAsState()
    val navController = rememberNavController()
    NavGraph(navController, screens)
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
        HTTPPediaApp()
}