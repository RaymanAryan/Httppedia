package com.rayman.httppedia.user_interface.screens.data_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SingleChoiceSegmentedButton(
    modifier: Modifier = Modifier,
    screens: Screens
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Errors", "Requests")

    SingleChoiceSegmentedButtonRow(modifier = modifier.fillMaxWidth()) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = {
                    selectedIndex = index
                    screens.currentScreen = if (label == "Requests") DataScreen.Ret else DataScreen.Errors
                },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}

@Preview
@Composable
fun SegmentedButtonPreview(){
    SingleChoiceSegmentedButton(screens = Screens())
}
