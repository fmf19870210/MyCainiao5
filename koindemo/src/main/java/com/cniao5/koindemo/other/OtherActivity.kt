package com.cniao5.koindemo.other

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cniao5.koindemo.CSKoinLog
import com.cniao5.koindemo.R
import org.koin.android.ext.android.inject

class OtherActivity: AppCompatActivity() {
     val  proData:ProData by inject()
    val  timeData:TimeData by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        CSKoinLog.I("通过 getProperty方式获取文件koin.properties里的数据:"+proData.string) //通过 getProperty方式获取文件koin.properties里的数据:hello Mr Fang, are you OK?

        CSKoinLog.I("通过timeData里面的属性ProD获取里面的参数string:"+timeData.ProD.string)
        // 通过timeData里面的属性ProD获取里面的参数string:hello Mr Fang, are you OK?
    }
}