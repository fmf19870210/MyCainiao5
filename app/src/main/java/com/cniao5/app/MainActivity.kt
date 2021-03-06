package com.cniao5.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cniao5.app.databinding.ActivityMainBinding
import com.cniao5.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutRes()= R.layout.activity_main

    override fun initConfig() {
        super.initConfig()

    }

    override fun initView() {
        super.initView()
        val navController = findNavController(R.id.fcv_main)
         // mBinding.bnvMain.setupWithNavController(navController)
            bnv_main.setupWithNavController(navController)
         }

    override fun initData() {
        super.initData()

    }





  /*
    //抽取到BaseActivity()里去
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fcv_main)
         nav_view.setupWithNavController(navController)
    }*/


}