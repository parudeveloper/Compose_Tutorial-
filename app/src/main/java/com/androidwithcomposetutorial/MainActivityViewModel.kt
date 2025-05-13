package com.androidwithcomposetutorial

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var counter = MutableLiveData<Int>(0)

    var incrementCounter = {
        counter.value = counter.value?.plus(1)
    }

    var decrementCounter = {
        counter.value = counter.value?.minus(1)
    }
}