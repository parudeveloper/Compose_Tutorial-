package com.androidwithcomposetutorial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var counter  = MutableLiveData<Int>(0)

    var counterNumber by mutableStateOf(0)

    fun incrementCounterNumber() {
        counterNumber++
    }

    fun decrementCounterNumber() {
        counterNumber--
    }

    var incrementCounter = {
        counter.value = counter.value?.plus(1)
    }

    var decrementCounter = {
        counter.value = counter.value?.minus(1)
    }
}

