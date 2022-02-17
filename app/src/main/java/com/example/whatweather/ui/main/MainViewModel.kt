package com.example.whatweather.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<String>()

    fun setLiveString(text: String) {
        mutableLiveData.value = text
    }

    fun getLiveString(): LiveData<String> {
        return mutableLiveData
    }

}