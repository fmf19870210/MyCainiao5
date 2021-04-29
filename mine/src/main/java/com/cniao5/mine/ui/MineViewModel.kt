package com.cniao5.mine.ui

import com.cniao5.common.base.BaseViewModel
import com.cniao5.mine.repo.IMineResource


/**
 * Mine模块的viewModel
 * */
class MineViewModel(private val repo: IMineResource):BaseViewModel() {


  // val  liveUserLiveData:MutableLiveData<CniaoUserInfo> = MutableLiveData<CniaoUserInfo>()

  //通过网络获取用户信息UserInfoRsp
  val  userInfoLiveData  = repo.userInfoLiveData



  /**
   * 获取用户信息数据
   */
  fun getUserInfo(token: String?) = serverAwait {
    token?.let {
      repo.getUserInfo(token)
    }
  }


}