package com.cniao5.mine

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.cniao5.common.base.BaseFragment
import com.cniao5.mine.databinding.FragmentMineBinding
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment(){


    override fun getLayoutRes()= R.layout.fragment_mine

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
   return  FragmentMineBinding.bind(view)
    }


    override fun initConfig() {
        super.initConfig()

        tv_title_fragment.text="我是个人中心"
    }
}