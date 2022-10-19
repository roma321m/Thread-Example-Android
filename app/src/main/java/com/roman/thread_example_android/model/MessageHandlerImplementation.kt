package com.roman.thread_example_android.model

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.roman.thread_example_android.model.Implementation.Companion.DELAY_TIME_IN_MILLI
import com.roman.thread_example_android.view_model.ViewModel
import com.roman.thread_example_android.view_model.ViewModel.Companion.DEFAULT_TEXT

class MessageHandlerImplementation(viewModel: ViewModel) : Implementation {

    companion object {
        const val MSG_CODE = 100
    }

    private val messageHandler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_CODE -> viewModel.updateText(msg.obj as String)
                else -> viewModel.updateText(DEFAULT_TEXT)
            }
        }
    }

    override fun onButtonClick(text: String) {
        messageHandler.removeMessages(MSG_CODE)
        messageHandler.sendMessageDelayed(messageHandler.obtainMessage(MSG_CODE, text), DELAY_TIME_IN_MILLI)
    }
}