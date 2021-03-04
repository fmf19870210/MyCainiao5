package com.cniao5.koindemo.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cniao5.koindemo.CSKoinLog
import com.cniao5.koindemo.R
import kotlinx.android.synthetic.main.activity_view_model.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewModelActivity : AppCompatActivity() {

    val myViewModel:MyViewModel by viewModel()
    val myViewModel2 by viewModel<MyViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_model)
         var i =0
        btn_change.setOnClickListener {
              myViewModel.NumData =i
             tv_change.text=myViewModel.NumData.toString()
              CSKoinLog.I(myViewModel.NumData.toString())
            CSKoinLog.I(myViewModel.hashCode().toString()) //222524363
             i++
        }



        btn_change2.setOnClickListener {
            i--
            myViewModel2.NumData = i
            tv_change2.text=myViewModel2.NumData.toString()
            CSKoinLog.I(myViewModel2.NumData.toString())
            CSKoinLog.I(myViewModel2.hashCode().toString()) //2255399
        }



    }

}