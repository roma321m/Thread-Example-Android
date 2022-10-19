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
    onTopLeftClicked: () -> Unit,
    onBottomLeftClicked: () -> Unit,
    onTopRightClicked: () -> Unit,
    onBottomRightClicked: () -> Unit,
    onMessageHandlerClicked: () -> Unit,
    onHandlerThreadClicked: () -> Unit
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
            Button(onClick = onTopLeftClicked) {
                Text(text = "Top Left")
            }
            Button(onClick = onTopRightClicked) {
                Text(text = "Top Right")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = onMessageHandlerClicked) {
                    Text(text = "Message Handler")
                }
                Button(onClick = onHandlerThreadClicked) {
                    Text(text = "Handler Thread")
                }
                Spacer(modifier = Modifier.padding(16.dp))
                Text(text = text)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onBottomLeftClicked) {
                Text(text = "Bottom Left")
            }
            Button(onClick = onBottomRightClicked) {
                Text(text = "Bottom Right")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThreadExampleAndroidTheme {
        MainScreen("", {}, {}, {}, {}, {}, {})
    }
}