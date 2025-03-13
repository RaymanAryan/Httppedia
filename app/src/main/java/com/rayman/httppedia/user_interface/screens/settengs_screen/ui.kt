package com.rayman.httppedia.user_interface.screens.settengs_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    val isDarkMode by viewModel.themeState.collectAsState()
    val username by viewModel.usernameState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        // Username Input
        Text("Welcome $username", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)
        var text by remember { mutableStateOf(username) }
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                viewModel.saveUsername(it)
            },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(), maxLines = 1
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Dark Mode Switch
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Dark Mode", modifier = Modifier.weight(1f))
            Switch(checked = isDarkMode, onCheckedChange = { viewModel.saveTheme(it) })
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Notifications Switch
        GitHubLink()
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
