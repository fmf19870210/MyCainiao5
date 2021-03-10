package com.cniao5.login

import android.content.Context
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.cniao5.common.base.BaseViewModel
import com.cniao5.login.net.LoginReqBody
import com.cniao5.login.net.RegisterRsp
import com.cniao5.login.repo.ILoginResource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class LoginViewModel(private val resource: ILoginResource): BaseViewModel(){

    //账号，密码 的observable 对象(通过databinding 绑定数据)
     val obMobile = ObservableField<String>()
     val obPassword = ObservableField<String>()


      // 注册的响应结果 liveRegisterRsp
    val liveRegisterRsp  = resource.registerRsp

    // 登录的响应结果 liveLoginRsp
     val liveLoginRsp=resource.loginRsp


  /*val catchEx = CoroutineExceptionHandler { coroutineContext, throwable ->
      LogUtils.e("异常 ${throwable.message}")
  }
    fun goLogin() {
         viewModelScope.launch(catchEx){
             resource.checkRegister("15101650501")
             resource.requestLogin(LoginReqBody("15101650501","FMF198702107813"))
         }
    }*/


    /*fun  goLogin(){
        serverAwait ({
            resource.checkRegister("15101650501")
            resource.requestLogin(LoginReqBody("15101650501","FMF198702107813"))
        })
    }*/

    /**
     *  点击登录按钮 进行登录
     * 调用登录，两步，1，判断手机号是否已经注册
     * 2，已经注册的，才去调用登录
     */

   fun  goLogin(){

     val account=    obMobile.get()?:return
   //     ToastUtils.showShort("点击登录${account}")
        //检测手机号是否账号
        checkRegister(account)
    }



    /**
     * 检查是否注册的账号
     */
    private fun checkRegister(account: String) {
        //{resource.checkRegister(mobi)} 是个lamuda 高阶函数  作为 serverAwait()函数的参数
          serverAwait({ resource.checkRegister(account)})
    }


//    private fun checkRegister(mobi: String) = serverAwait {
//        resource.checkRegister(mobi)
//    }


    /**
     * 调用登录接口
     * val mobi: String = "18648957777",
     * val password: String = "cn5123456"
     */

     internal  fun  repoLogin(){
            val account = obMobile.get()?:return
          val password = obPassword.get()?:return
        serverAwait ({
             resource.requestLogin(LoginReqBody(account,password))
        })
    }


    fun wechat(ctx: Context) {
        ToastUtils.showShort("点击了微信登录")
    }

    fun qq(v: View) {
        ToastUtils.showShort("点击了QQ登录")
    }

    fun weibo() {
        ToastUtils.showShort("点击了微博登录")
    }

    fun AA(view: View) {
        ToastUtils.showShort("忘记密码")
    }
}












