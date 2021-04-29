package com.cniao5.login.net

import androidx.annotation.Keep
import com.cniao5.service.repo.CniaoUserInfo

/**
  登录成功响应类   出参的结果实体类对象
  */

/**
 * 查询手机号码是否注册的接口响应返回实体类
 */

@Keep
data class  RegisterRsp(
    val is_register: Int = FLAG_UN_REGISTERED// 1 表示注册，0 表示未注册
){

    companion object{
        const val FLAG_IS_REGISTERED = 1//已经注册的
        const val FLAG_UN_REGISTERED = 0//0 表示未注册
    }

}


/**
 * 手机号和密码登录成功  接口响应返回实体类LoginRsp(即为CniaoUserInfo )
 */
// 给 LoginRsp 取别名  CniaoUserInfo,不影响其他地方调用LoginRsp
typealias LoginRsp = CniaoUserInfo





