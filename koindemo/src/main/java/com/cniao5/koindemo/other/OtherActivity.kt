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

        CSKoinLog.I("ͨ�� getProperty��ʽ��ȡ�ļ�koin.properties�������:"+proData.string) //ͨ�� getProperty��ʽ��ȡ�ļ�koin.properties�������:hello Mr Fang, are you OK?

        CSKoinLog.I("ͨ��timeData���������ProD��ȡ����Ĳ���string:"+timeData.ProD.string)
        // ͨ��timeData���������ProD��ȡ����Ĳ���string:hello Mr Fang, are you OK?
    }
}