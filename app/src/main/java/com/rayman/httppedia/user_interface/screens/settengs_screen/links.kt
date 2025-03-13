package com.rayman.httppedia.user_interface.screens.settengs_screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun GitHubLink() {
    val context = LocalContext.current
    val url = "https://github.com/RaymanAryan/Httppedia"

    Text(
        text = "View Source on GitHub",
        color = Color.Blue,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }
            .padding(8.dp)
    )
}
