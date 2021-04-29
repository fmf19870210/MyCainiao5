package com.cniao5.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.cniao5.app.ui.dashboard.DashboardViewModel
import com.cniao5.common.BaseApplication
import com.cniao5.common.ktx.application
import com.cniao5.login.moduleLogin
import com.cniao5.mine.moduleMine
import com.cniao5.service.assistant.AssistantApp
import com.cniao5.service.moduleService
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.dsl.module

class CnApplication  : BaseApplication(){

  private val modules = arrayListOf<Module>(
      moduleService, /*moduleHome,*/ moduleLogin, moduleMine
  )


    override fun initConfig() {
        super.initConfig()

        //添加common 模块之外的其他模块，组件的koin的modules
        loadKoinModules(modules)
        //初始化module
     //滴滴的doKit的初始化配置
      AssistantApp.initConfig(application)
        //初始化组件化
        ARouter.init(application)
    }
}
























