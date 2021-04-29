package com.cniao5.mine.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ToastUtils
import com.cniao5.common.base.BaseFragment
import com.cniao5.mine.R
import com.cniao5.mine.databinding.FragmentMineBinding
import com.cniao5.mine.net.UserInfoRsp
import com.cniao5.service.repo.CniaoDbHelper
import com.cniao5.service.repo.CniaoUserInfo
import kotlinx.android.synthetic.main.fragment_mine.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MineFragment : BaseFragment(){
   private  val viewModel: MineViewModel by viewModel()

    override fun getLayoutRes()= R.layout.fragment_mine

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
       return  FragmentMineBinding.bind(view).apply {
           // todo 把viewModel 和布局的vm绑定
          //布局文件通过vm.liveUserLiveData=viewModel.liveUserLiveData 获取数据
           vm=viewModel
           //点击按钮  登出登录
           btn_logout_mine.setOnClickListener {
               //删除数据库里用户信息
               CniaoDbHelper.deleteUserInfo(requireContext())
                ToastUtils.showLong("退出登录成功")
               ARouter.getInstance().build("/login/login").navigation()
           }

            /**
             * 点击iv_user_icon_mine的行为:通过action 跳转到UserInfoFragment界面
             * */
           //跳转到UserInfoFragment界面 并且携带参数数据 userInfoRsp
           iv_user_icon_mine.setOnClickListener {
                 val  userInfoLiveData:LiveData<UserInfoRsp>  = viewModel.userInfoLiveData
                 val userInfoRsp:UserInfoRsp? =  userInfoLiveData.value
                 if(userInfoRsp==null){
                     ARouter.getInstance().build("/login/login").navigation()

                 }else{
                     userInfoRsp.company = "安卓程序员"
                     val action = MineFragmentDirections.actionMineFragmentToUserInfoFragment(userInfoRsp)
                     findNavController().navigate(action)
                 }


           }
       }
    }


    override fun initData() {
        super.initData()
  /**
   *  把从数据库里获取的用户信息,赋值给viewModel.liveUserLiveData
   * */
    val  userInfoLiveData : LiveData<CniaoUserInfo> = CniaoDbHelper.getLiveUserDataInfo(requireContext())
        userInfoLiveData.observe(this, Observer<CniaoUserInfo> {
           //给viewModel.liveUserLiveData赋值数据CniaoUserInfo
           // viewModel.liveUserLiveData.postValue(it)
         //获取网络用户个人信息数据
          viewModel.getUserInfo(it?.token)

        })
    }


}