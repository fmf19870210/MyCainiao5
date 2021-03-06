package com.cniao5.service.assistant

import android.content.Context
import com.cniao5.service.R
import com.didichuxing.doraemonkit.kit.AbstractKit


/**
 *
 * 用于配置切换不同的接口host，调试工具
 *
 * */
class ServerHostKit  : AbstractKit()  {
    override val icon: Int
        get() =  R.drawable.icon_server_host
    override val name: Int
        get() = R.string.str_server_host_dokit


    override fun onAppInit(context: Context?) {
        //
    }

    override fun onClick(context: Context?) {
        //
    }

}