package com.cniao5.service.assistant

import android.app.Application
import com.didichuxing.doraemonkit.DoraemonKit


/**
* 配置滴滴的doKit的工具类
*
* */
object AssistantApp {

      fun initConfig(application: Application){
            DoraemonKit.install(application, mutableListOf( ServerHostKit()))
      }


}