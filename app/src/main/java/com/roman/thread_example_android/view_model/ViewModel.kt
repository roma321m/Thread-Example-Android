package com.roman.thread_example_android.view_model

import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.roman.thread_example_android.util.Constants.DEFAULT_TEXT
import com.roman.thread_example_android.util.Constants.DELAY_TIME_IN_MILLI
import com.roman.thread_example_android.util.Constants.MSG_CODE

class ViewModel {

    var text by mutableStateOf(DEFAULT_TEXT)
        private set

    private fun updateText(newText: String) {
        text = newText
    }

    private val messageHandler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_CODE -> updateText(msg.obj as String)
                else -> updateText(DEFAULT_TEXT)
            }
        }
    }

    fun buttonClick(msg: String) {
        messageHandler.removeMessages(MSG_CODE)
        messageHandler.sendMessageDelayed(messageHandler.obtainMessage(MSG_CODE, msg), DELAY_TIME_IN_MILLI)
    }
}