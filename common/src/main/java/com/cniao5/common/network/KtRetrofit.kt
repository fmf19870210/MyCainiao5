package com.cniao5.common.network

import com.cniao5.common.network.config.CniaoHeaderInterceptor
import com.cniao5.common.network.config.LocalCookieJar
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


/**
 *   2021-02-07
 * 封装的retrofit请求类
 */
object KtRetrofit {

     private val  mOkHttpClient =  OkHttpClient.Builder()
         .callTimeout(10, TimeUnit.SECONDS)//完整请求超时时长，从发起到接收返回数据，默认值0，不限定,
         .connectTimeout(10, TimeUnit.SECONDS)//与服务器建立连接的时长，默认10s
         .readTimeout(10, TimeUnit.SECONDS)//读取服务器返回数据的时长
         .writeTimeout(10, TimeUnit.SECONDS)//向服务器写入数据的时长，默认10s
         .retryOnConnectionFailure(true)//重连
         .followRedirects(false)//重定向
         .cookieJar(LocalCookieJar())
         .addNetworkInterceptor(CniaoHeaderInterceptor())//公共header的拦截器


}




























