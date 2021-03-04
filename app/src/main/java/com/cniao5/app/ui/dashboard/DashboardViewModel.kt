package com.cniao5.app.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel: ViewModel() {


     private   val  textMutableLiveData  = MutableLiveData<String>()

       fun getLiveData(): MutableLiveData<String>{
          return textMutableLiveData
       }


         fun setViewModelData(str:String){
         textMutableLiveData.postValue(str)
        }

      fun getViewModelData(){
          textMutableLiveData.value
      }

}