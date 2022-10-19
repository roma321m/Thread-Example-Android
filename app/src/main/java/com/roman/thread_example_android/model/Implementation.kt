package com.roman.thread_example_android.model

interface Implementation {

    companion object {
        const val DELAY_TIME_IN_MILLI: Long = 3000
    }

    fun onButtonClick(text: String)
}