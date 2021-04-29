package com.cniao5.mine.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.cniao5.common.network.support.serverData
import com.cniao5.mine.net.MineService
import com.cniao5.mine.net.UserInfoRsp
import com.cniao5.service.network.onBizError
import com.cniao5.service.network.onBizOK
import com.cniao5.service.network.onFailure
import com.cniao5.service.network.onSuccess

class MineRepo(private val service: MineService):IMineResource{

    private val _userInfoRsp = MutableLiveData<UserInfoRsp>()
    override val userInfoLiveData: LiveData<UserInfoRsp> =_userInfoRsp

    override suspend fun getUserInfo(token: String?) {
         service.getUserInfo(token)
             .serverData()
             .onSuccess {
                 onBizError{code,message->
                     LogUtils.w("获取用户信息 BizError $code,$message")
                 }
                 onBizOK<UserInfoRsp>{code, data, message ->
                     LogUtils.i("获取用户信息 BizOK $data")
                     _userInfoRsp.value=data
                     return@onBizOK
                 }
             }
             .onFailure{
                 LogUtils.e("获取用户信息 接口异常 ${it.message}")
             }
    }

}