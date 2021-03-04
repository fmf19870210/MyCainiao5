package com.cniao5.koindemo.single

import com.cniao5.koindemo.CSKoinLog


/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class UserData {
    var userName: String? = null
    var age: Int? = null
    fun info() {
        CSKoinLog.I("用户名:" + userName + "////年龄:" + age)
    }
}