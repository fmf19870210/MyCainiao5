package com.cniao5.koindemo.normal

import android.view.View

import com.cniao5.koindemo.CSKoinLog

/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class ViewData(val view: View) {
    fun prinId() {
        CSKoinLog.I("获取ViewData的按钮id: " + view.id.toString())
    }
}