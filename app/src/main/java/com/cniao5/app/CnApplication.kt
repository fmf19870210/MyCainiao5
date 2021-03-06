package com.cniao5.app

import android.app.Application
import com.cniao5.app.ui.dashboard.DashboardViewModel
import com.cniao5.common.BaseApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class CnApplication  : BaseApplication(){


    override fun initConfig() {
        super.initConfig()

        //doKit的初始化配置
      //  AssistantApp.initConfig(application)
    }





}
























