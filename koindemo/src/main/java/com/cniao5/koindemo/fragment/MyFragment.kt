package com.cniao5.koindemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cniao5.koindemo.CSKoinLog
import com.cniao5.koindemo.R


/**
 *  被注解生成的fragment
 *
 * */
class MyFragment (val str: String) : Fragment(){
  override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        CSKoinLog.I("传递给碎片MyFragment的参数:"+str)  // 传递给碎片MyFragment的参数:方明飞啊
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

}













