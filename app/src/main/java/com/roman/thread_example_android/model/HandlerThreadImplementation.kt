package com.roman.thread_example_android.model

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import com.roman.thread_example_android.model.Implementation.Companion.DELAY_TIME_IN_MILLI
import com.roman.thread_example_android.view_model.ViewModel

class HandlerThreadImplementation(viewModel: ViewModel): Implementation {

    private val myHandlerThread = HandlerThread("myThread")
    private lateinit var myHandler: Handler
    private var first = true
    private var text: String? = null

    private fun init() {
        if (first) {
            first = false
            myHandlerThread.start()
            myHandler = Handler(myHandlerThread.looper)
        }
    }

    private val task = Runnable {
        Handler(Looper.getMainLooper()).post {
            text?.let {
                viewModel.updateText(it)
            }
        }
    }

    override fun onButtonClick(text: String) {
        init()
        this.text = text
        myHandler.removeCallbacks(task)
        myHandler.postDelayed(task, DELAY_TIME_IN_MILLI)
    }

}