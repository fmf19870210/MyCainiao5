package com.cniao5.koindemo.libmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cniao5.koindemo.CSKoinLog
import com.cniao5.koindemo.R
import com.cniao5.moduleinjectkoin.LibData
import org.koin.android.ext.android.inject

class LibModuleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lib_module)
           /**
            *  直接获取libLibray的注入实体类LibData
            *
            * */
         val  libData by inject<LibData>()

        CSKoinLog.I("直接获取libLibray的注入实体类LibData:" +libData.name ) //直接获取libLibray的注入实体类LibData:王明明

        /**
        *在ModuleData类中的获取libLibray的注入实体类对象libData
        *
        * */

           val moduleData by inject<ModuleData>()
          CSKoinLog.I("在ModuleData类中的获取libLibray的注入实体类对象libData:"+moduleData.libData.name) //在ModuleData类中的获取注入实体类对象libData:王明明

    }

}