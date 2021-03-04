package com.cniao5.koindemo.normal

import com.cniao5.koindemo.CSKoinLog
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject


/**
 *   如何在普通类中 获取使用注入inject对象呢？
 *     此普通类 实现接口 KoinComponent即可
 *
 *
 * */
class CompontData : KoinComponent {
   val  appD1 by inject<AppData>() //懒加载模式获取注入对象AppData
    val appD2 = get<AppData>()//非懒加载模式 获取注入对象AppData
    fun  printInjectInfo(){
       CSKoinLog.I("普通类CompontData中输出注入对象appD1地址信息:" + appD1.hashCode() + "////输出注入对象appD2地址信息:" + appD2.hashCode())
   }

}