package com.cniao5.moduleinjectkoin

import org.koin.dsl.module


/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
object libModule {
    val theLibModule = module {
        //koin支持多个module注入
        single { LibData() }//这边用single方式注入
    }
}