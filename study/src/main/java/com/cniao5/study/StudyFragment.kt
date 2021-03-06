package com.cniao5.study

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.cniao5.common.base.BaseFragment
import com.cniao5.study.databinding.FragmentStudyBinding
import kotlinx.android.synthetic.main.fragment_study.*

class StudyFragment:BaseFragment() {


    override fun getLayoutRes()  = R.layout.fragment_study


    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
                     return  FragmentStudyBinding.bind(view)
    }


    override fun initConfig() {
        super.initConfig()
        tv_title_fragment.text="我是学习"

    }
}