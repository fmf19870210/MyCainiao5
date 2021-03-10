package com.cniao5.login.repo

import androidx.lifecycle.LiveData
import com.blankj.utilcode.util.LogUtils
import com.cniao5.common.model.SingleLiveData
import com.cniao5.common.network.support.serverData
import com.cniao5.login.net.LoginReqBody
import com.cniao5.login.net.LoginRsp
import com.cniao5.login.net.LoginService
import com.cniao5.login.net.RegisterRsp
import com.cniao5.service.network.onBizError
import com.cniao5.service.network.onBizOK

import com.cniao5.service.network.onFailure
import com.cniao5.service.network.onSuccess

class LoginRepo(private val service: LoginService):ILoginResource {
     //私有的  _registerRsp 注册的响应结果
   private val  _registerRsp=SingleLiveData<RegisterRsp>()
    //私有的  _loginRsp登录的响应结果
   private  val  _loginRsp=SingleLiveData<LoginRsp>()


   //对外公开的 可以 setValue postValue   registerRsp= _registerRsp 注册的响应结果
    override val registerRsp: LiveData<RegisterRsp> =_registerRsp
    //对外公开的 可以 setValue postValue   loginRsp= _loginRsp 登录的响应结果
    override val loginRsp: LiveData<LoginRsp> =_loginRsp


    override suspend fun checkRegister(mobi: String) {
      service.isRegister(mobi).serverData()
          .onSuccess{
                onBizOK<RegisterRsp> { code, data, message ->
                    _registerRsp.value=data
                    LogUtils.i("是否注册 BizOK $data")
                    return@onBizOK
                }
              onBizError({code,message->
                  LogUtils.w("是否注册 BizError $code,$message")
              })


          }
          .onFailure {
              LogUtils.e("是否注册 接口异常 ${it.message}")
          }

    }

    override suspend fun requestLogin(body: LoginReqBody) {
            service.login(body)
                .serverData()
                .onSuccess {
                    onBizOK<LoginRsp>  { code, data, message ->
                        _loginRsp.value=data
                        //同步到room数据库，登录状态
                        LogUtils.i("登录接口成功: BizOK $data")
                    }
                    onBizError { code, message ->
                        LogUtils.w("登录接口 BizError $code,$message")
                    }
                }
                .onFailure {   LogUtils.e("登录接口 异常 ${it.message}") }

    }


}