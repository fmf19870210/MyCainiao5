package com.cniao5.app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.cniao5.app.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment: Fragment() {
 private val     dashboardViewModel :DashboardViewModel by viewModel()

        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //todo 我们是同通过传统的方式获取viewmodel对象的
       // val   dashboardViewModel :DashboardViewModel=    ViewModelProviders.of(this).get(DashboardViewModel::class.java)
       dashboardViewModel.setViewModelData("This is dashboard Fragment")
        val textMutableLiveData= dashboardViewModel.getLiveData()
        textMutableLiveData.observe( viewLifecycleOwner, Observer {
            text_dashboard.text=it
        })

         return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }





}