package com.roman.thread_example_android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.roman.thread_example_android.ui.screens.MainScreen
import com.roman.thread_example_android.ui.theme.ThreadExampleAndroidTheme
import com.roman.thread_example_android.util.Constants.BOTTOM_LEFT
import com.roman.thread_example_android.util.Constants.BOTTOM_RIGHT
import com.roman.thread_example_android.util.Constants.TOP_LEFT
import com.roman.thread_example_android.util.Constants.TOP_RIGHT
import com.roman.thread_example_android.view_model.ViewModel

class MainActivity : ComponentActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private val viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "onCreate")

        setContent {
            ThreadExampleAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(
                        text = viewModel.text,
                        onTopLeftClick = {
                            viewModel.buttonClick(TOP_LEFT)
                        },
                        onTopRightClick = {
                            viewModel.buttonClick(TOP_RIGHT)
                        },
                        onBottomLeftClick = {
                            viewModel.buttonClick(BOTTOM_LEFT)
                        },
                        onBottomRightClick = {
                            viewModel.buttonClick(BOTTOM_RIGHT)
                        }
                    )
                }
            }
        }
    }
}
