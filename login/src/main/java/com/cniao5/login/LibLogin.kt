package com.cniao5.login

import com.cniao5.common.network.KtRetrofit
import com.cniao5.common.network.config.BASE_HOST
import com.cniao5.common.network.config.NET_CONFIG_APPKEY
import com.cniao5.login.net.LoginService
import com.cniao5.login.repo.ILoginResource
import com.cniao5.login.repo.LoginRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module


/**
 *  登录的koin 注入 module
 *
 * */


val   moduleLogin  = module {

    //service retrofit  返回LoginService 对象
    single {
       KtRetrofit.initConfig(BASE_HOST)
           .getService(LoginService::class.java)
    }


   // LoginRepo  返回LoginRepo对象

    /**
     * get() 直接从容器里获取LoginService对象
     *   在上面 我们 已经往容器里存储了LoginService::class.java 实体对象
     *
     * */
   single{
       LoginRepo(get())
   } bind  ILoginResource::class


    //viewModel

    /**
     * get() 获取  ILoginResource接口
     * 我们在上面已经存储了 bind  ILoginResource::class
     * */
    viewModel {
        LoginViewModel(get())
    }
}