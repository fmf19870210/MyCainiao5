package com.cniao5.koindemo.normal

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.cniao5.koindemo.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class NormalTwoActivity : AppCompatActivity(){
val weatherData by  inject<WeatherData>(named("wea_name"))
    val weatherData2 by inject<WeatherData>(named("wea_app"))
    val weatherData3 by inject<WeatherData>(named("wea_appData"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_two)
        weatherData.printData("weather1")    //weather1的信息    numData:12///userName:曹老板///application是否为空:true///appData是否为空:true
        weatherData2.printData("weather2")  //weather2的信息    numData:0///userName:///application是否为空:false///appData是否为空:true
        weatherData3.printData("weather3")  //weather3的信息    numData:0///userName:///application是否为空:true///appData是否为空:false


     ////////////////////////
   //外部参数 btnShow:Button
      val  btnShow:Button  = findViewById<Button>(R.id.btn_show)
    //这个通过   parametersOf(vararg parameters: Any?)方法来传入外部参数对象  btnShow
     val viewData by inject<ViewData>{ parametersOf(btnShow)}
        viewData.prinId() //输出外部参数对象btnShow的信息:获取ViewData实体对象传入的外部参数btnShow的id: 2131230817


   ////////////////////////

     CompontData().printInjectInfo() //普通类CompontData中输出注入对象appD1地址信息:262823653////输出注入对象appD2地址信息:244473274

    }
}


















