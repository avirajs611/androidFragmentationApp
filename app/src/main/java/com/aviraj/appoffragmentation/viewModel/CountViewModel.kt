package com.aviraj.appoffragmentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel(){

    // livedata which is available in RAM
    private var mutableCountLiveData = MutableLiveData<Int>()

    init {
        mutableCountLiveData.value = 0
    }

    fun getMutableData(): LiveData<Int> {
        return mutableCountLiveData
    }
}