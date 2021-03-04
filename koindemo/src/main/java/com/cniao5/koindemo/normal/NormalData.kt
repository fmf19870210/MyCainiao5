package com.cniao5.koindemo.normal

import android.app.Application
import com.cniao5.koindemo.CSKoinLog


/**
 * NormalData类,里面是有三个构造函数,而且需要的参数都不同
 * 怎么区分这3个不同的构造函数？
 *  使用qualifier限定符,对三个构造函数进行区分。
 *  qualifier限定符,就是标签,给每一个注入的构造函数贴个不同的标签
 *   我们通过qualifier标签获取不同的构造函数。
 *
 *
 * */
class NormalData {

    var numData: Int = 0
    var userName: String = ""
    constructor(userName: String, numData: Int) {//构造方法1
        this.userName = userName
        this.numData = numData
    }


    var appData: AppData? = null
    constructor(appData: AppData) {//构造方法2
        this.appData = appData
    }


    var mApp: Application? = null
    constructor(mApp: Application) {//构造方法3
        this.mApp = mApp
    }

    fun printInfo(str: String) {//打印里面的信息
        CSKoinLog.I(str + "的信息    numData:" + numData + "///userName:" + userName + "///application是否为空:" + (mApp == null) + "///appData是否为空:" + (appData == null))
    }


}