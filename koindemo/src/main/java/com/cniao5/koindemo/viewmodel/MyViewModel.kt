package com.cniao5.koindemo.viewmodel

import androidx.lifecycle.ViewModel
import com.cniao5.koindemo.CSKoinLog

class MyViewModel: ViewModel() {

    var NumData :Int = 0
    override fun onCleared() {
        super.onCleared()
        CSKoinLog.I("调用了销毁方法")
    }




}