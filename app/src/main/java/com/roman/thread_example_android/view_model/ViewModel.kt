package com.roman.thread_example_android.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.roman.thread_example_android.model.HandlerThreadImplementation
import com.roman.thread_example_android.model.Implementation
import com.roman.thread_example_android.model.ImplementationType
import com.roman.thread_example_android.model.MessageHandlerImplementation

class ViewModel {

    companion object {
        const val DEFAULT_TEXT = "Change this text with handler"
    }

    var text by mutableStateOf(DEFAULT_TEXT)
        private set

    fun updateText(newText: String) {
        text = newText
    }

    private var implementationType by mutableStateOf(ImplementationType.MESSAGE_HANDLER)

    fun updateImplementationState(newState: ImplementationType) {
        implementationType = newState
    }

    private var implementation: Implementation = HandlerThreadImplementation(this)

    // todo - use in main to change implementation style
    fun updateImplementation() {
        when (implementationType) {
            ImplementationType.MESSAGE_HANDLER -> {
                implementation = MessageHandlerImplementation(this)
            }
            ImplementationType.HANDLER_THREAD -> {
                implementation = HandlerThreadImplementation(this)
            }
        }
    }

    fun buttonClick(text: String) {
        implementation.onButtonClick(text)
    }
}