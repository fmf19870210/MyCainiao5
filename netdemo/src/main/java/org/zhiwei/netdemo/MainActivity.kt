package org.zhiwei.netdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.LogUtils
import com.cniao5.common.network.KtRetrofit
import com.cniao5.common.network.OkHttpApi
import com.cniao5.common.network.model.*
import com.cniao5.common.network.support.serverRsp
import com.cniao5.common.network.support.toLiveData
import kotlinx.coroutines.launch
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitCall: Call<NetResponse> = KtRetrofit.initConfig("https://course.api.cniao5.com/")
           .getService(CniaoService::class.java)
           .userInfo()
            //ktx的liveData
       val  liveInfo = retrofitCall.toLiveData()
        liveInfo.observe(this, Observer { LogUtils.d("retrofit userInfo ${it.toString()}") })


        val loginCall: Call<NetResponse> = KtRetrofit.initConfig(
            "https://course.api.cniao5.com/",
            OkHttpApi.getInstance().getClient()
        )
            .getService(CniaoService::class.java)
            .login(LoginReq())

         //使用协程
        lifecycleScope.launch {
            //表达式声明，使用 when，协程，同步的代码形式，执行异步的操作，
         val serverRsp =  loginCall.serverRsp()
           when(serverRsp ){
               is ApiSuccessResponse -> {
                   LogUtils.i("apiService ${serverRsp.body.toString()}")
               }
               is ApiErrorResponse -> {
                   LogUtils.e("apiService ${serverRsp.errorMessage}")
               }
               is ApiEmptyResponse -> {
                   LogUtils.d("empty apiResponse ")
               }
           }
        }


        //retrofit adpater 的 liveData
       val userInfo2LiveData:LiveData<ApiResponse<NetResponse>> = KtRetrofit.initConfig("https://course.api.cniao5.com/")
                                .getService(CniaoService::class.java)
                                  .userInfo2()
        userInfo2LiveData.observe(this,
            Observer<ApiResponse<NetResponse>> {
                    t -> LogUtils.d("retrofit liveRsp ${t.toString()}")
            })

    }
}



















