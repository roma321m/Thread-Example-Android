package com.roman.thread_example_android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roman.thread_example_android.ui.theme.ThreadExampleAndroidTheme

@Composable
fun MainScreen(
    text: String,
    onTopLeftClick: () -> Unit,
    onBottomLeftClick: () -> Unit,
    onTopRightClick: () -> Unit,
    onBottomRightClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onTopLeftClick) {
                Text(text = "Top Left")
            }
            Button(onClick = onTopRightClick) {
                Text(text = "Top Right")
            }
        }
        Text(text = text)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onBottomLeftClick) {
                Text(text = "Bottom Left")
            }
            Button(onClick = onBottomRightClick) {
                Text(text = "Bottom Right")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThreadExampleAndroidTheme {
        MainScreen("", {}, {}, {}, {})
    }
}