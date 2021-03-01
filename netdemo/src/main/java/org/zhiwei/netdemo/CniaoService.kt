package org.zhiwei.netdemo

import androidx.lifecycle.LiveData
import com.cniao5.common.network.model.ApiResponse
import com.cniao5.common.network.model.NetResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CniaoService {

    @POST("accounts/course/10301/login")
    fun login(@Body body: LoginReq): Call<NetResponse>

    @GET("member/userinfo")
    fun userInfo(): Call<NetResponse>

    @GET("member/userinfo")
    fun userInfo2(): LiveData<ApiResponse<NetResponse>>
}