package com.cniao5.login.net

import androidx.annotation.Keep

/**
  登录请求入参实体类对象LoginReqBody
 */

@Keep
data class LoginReqBody(
    val mobi: String,
    val password: String
)