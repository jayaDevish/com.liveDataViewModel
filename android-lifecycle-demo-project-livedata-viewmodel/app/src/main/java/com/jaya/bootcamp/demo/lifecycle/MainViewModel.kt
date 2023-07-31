package com.jaya.bootcamp.demo.lifecycle

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val timerData = MutableLiveData<String>()

    private val timer = object : CountDownTimer(60000, 3000) {
        override fun onFinish() {
            timerData.postValue("Finish")
        }

        override fun onTick(millisUntilFinished: Long) {
            timerData.postValue("$millisUntilFinished")
        }
    }

    fun start() {
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}