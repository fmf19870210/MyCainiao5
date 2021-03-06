package com.cniao5.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.cniao5.common.base.BaseFragment
import com.cniao5.home.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment(){

    override fun getLayoutRes()= R.layout.fragment_home
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
         return  FragmentHomeBinding.bind(view).also {
              it.tvTitleFragment.text="我是首页1"
         }
    }


    override fun initConfig() {
        super.initConfig()
        tv_title_fragment.text="我是首页2"
    }

 }