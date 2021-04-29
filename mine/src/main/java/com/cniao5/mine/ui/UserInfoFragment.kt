package com.cniao5.mine.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cniao5.common.base.BaseFragment
import com.cniao5.mine.R
import com.cniao5.mine.databinding.FragmentUserInfoBinding
import com.cniao5.service.repo.CniaoDbHelper
import com.cniao5.service.repo.CniaoUserInfo
import kotlinx.android.synthetic.main.fragment_user_info.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 *
 * 用户信息界面Fragment
 *
 *
 * */
class UserInfoFragment : BaseFragment(){


   //通过action 携带传递过来的数据UserInfoRsp 都封装在UserInfoFragmentArgs里
    private val args by navArgs<UserInfoFragmentArgs>()



    override fun getLayoutRes(): Int {
        return  R.layout.fragment_user_info
    }



    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
    return FragmentUserInfoBinding.bind(view).apply {

        //toolbar返回界面
        toolbarUserInfo.setNavigationOnClickListener { findNavController().navigateUp() }
        toolbar_user_info.navigationIcon?.setTint(Color.WHITE)
        btn_save_user_info.setOnClickListener {
            findNavController().navigateUp()
        }

          // 通过args 获取userInfo: UserInfoRsp 对象 赋值给布局databing 的 userInfo
          userInfo = args.userInfo

    }
    }


    override fun initData() {
        super.initData()
        val  userInfoLiveData :  LiveData<CniaoUserInfo> = CniaoDbHelper.getLiveUserDataInfo(requireContext())
        userInfoLiveData.observe(viewLifecycleOwner, Observer <CniaoUserInfo>{

        })

    }






}