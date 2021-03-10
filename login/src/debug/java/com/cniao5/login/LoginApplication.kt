package com.cniao5.login

import com.cniao5.common.BaseApplication
import org.koin.core.context.loadKoinModules

class LoginApplication : BaseApplication() {


    override fun initConfig() {
        super.initConfig()
        //Koin加载外部的外部 moduleService
     //   loadKoinModules(moduleService)
        //Koin加载外部的外部 moduleLogin
        loadKoinModules(moduleLogin)

    }
}