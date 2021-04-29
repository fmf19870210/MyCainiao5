package com.cniao5.login

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.cniao5.common.base.BaseActivity
import com.cniao5.common.ktx.context
import com.cniao5.login.databinding.ActivityLoginBinding
import com.cniao5.login.net.RegisterRsp
import com.cniao5.service.repo.CniaoDbHelper
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

@Route(path = "/login/login")
class LoginActivity :BaseActivity<ActivityLoginBinding>() {
  private val viewModel :LoginViewModel by viewModel()




    override fun getLayoutRes(): Int {
         return R.layout.activity_login
    }

    override fun initView() {
        super.initView()

         mBinding.vm=viewModel
        //关闭当前界面
        mBinding.mtoolbarLogin.setNavigationOnClickListener { finish() }
        mBinding.tvRegisterLogin.setOnClickListener {
            ToastUtils.showShort("当前课程项目未实现注册账号功能!")
        }
    }


    override fun initConfig() {
        super.initConfig()
        viewModel.apply {
            liveRegisterRsp.observe(this@LoginActivity, Observer  {
                   //放回的是否注册的响应结果:it.is_register =1  已经注册的，直接去登录
                   if(it.is_register==RegisterRsp.FLAG_IS_REGISTERED){
                        repoLogin()
                   }
            })
            liveLoginRsp.observeKt{rsp ->
                ToastUtils.showShort("我的登录结果 " + rsp.toString())
                rsp?.let {
                    //用户信息同步到数据库
                    CniaoDbHelper.insertUserInfo(context, it)
                }
                 finish()
            }


        }

    }




}