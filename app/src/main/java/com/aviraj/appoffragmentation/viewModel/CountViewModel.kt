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

    fun increment(){
        mutableCountLiveData.value = mutableCountLiveData.value?.plus(1)
    }

    fun decrement(){
        mutableCountLiveData.value = mutableCountLiveData.value?.minus(1)
    }

    fun getMutableData(): LiveData<Int> {
        return mutableCountLiveData
    }
}