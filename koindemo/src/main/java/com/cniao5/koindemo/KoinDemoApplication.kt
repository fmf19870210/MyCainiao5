package com.cniao5.koindemo

import android.app.Application
import android.view.View
import com.cniao5.koindemo.factory.Person
import com.cniao5.koindemo.fragment.MyFragment
import com.cniao5.koindemo.libmodule.ModuleData
import com.cniao5.koindemo.normal.AppData
import com.cniao5.koindemo.normal.NormalData
import com.cniao5.koindemo.normal.ViewData
import com.cniao5.koindemo.normal.WeatherData
import com.cniao5.koindemo.other.ProData
import com.cniao5.koindemo.other.TimeData
import com.cniao5.koindemo.single.UserData
import com.cniao5.koindemo.viewmodel.MyViewModel
import com.cniao5.moduleinjectkoin.LibData
import com.cniao5.moduleinjectkoin.libModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class KoinDemoApplication:Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            //开始启动koin
            androidContext(this@KoinDemoApplication)//这边传Application对象,这样你注入的类中,需要app对象的时候,可以直接使用
            androidFileProperties()//默认名字为koin.properties,你也可以直接重新设置名称
           /**
            * appModule 是 本项目的module依赖注入
            * libModule.theLibModule 是 本项目 依赖的的第三方的lib库里 的module依赖注入
            * */
            modules(appModule, libModule.theLibModule)//这里面传各种被注入的模块对象,支持多模块注入,在2.0.1之后才支持vararg调用
        }

        loadKoinModules(otherModule)

     }

    //里面添加各种注入对象
   val  appModule = module {
    //普通注入使用方式--Factory注入:注入对象Person,每次创建的对象Person不同
       factory {
           Person()
       }

        single {
            //单例的注入方式:每次创建的对象UserData都是唯一的
            UserData()
        }


        viewModel {
            MyViewModel()
        }

   /**
    *  被注解的实体对象AppData,带有构造参数
    *get():表示application对象.
    * 开始初始化Koin的时候,传了一个androidContext(this@MyApp),将appLication对象传了进去,Koin中,就已经记录了这个application对象
    *
    * */

        factory {
            AppData(get())
        }


        /**
         *  以下三个不同的构造函数,通过 Qualifier的named(name: String)的方法来进行标记
         *
         * */
        //注入构造函数一:NormalData("曹老板", 12)
        // 'nameAnum'标签的类中,只有字符串和数字
        factory(named("nameAnum")) {
            //该限定符的构造方法中包含字符串和数字
            NormalData("曹老板", 12)
        }

    // 注入构造函数二:NormalData(get<Application>())
        // 'app'标签的类中,只有application对象,

        factory(named("app")) {
            //该限定符定义构造方法中有appliaction的
             // get()的泛型T=Application, 注入
            NormalData(get<Application>())
        }

          //注入构造函数三: NormalData(get<AppData>())
        //'appData'标签的类中,只有AppData
        factory(named("appData")) {
            //该限定符定义构造方法中有AppData的
            // get()的泛型T=AppData, 注入
            NormalData(get<AppData>())
        }



       factory(named("wea_name")){
           WeatherData(get<NormalData>(named("nameAnum")))
           //这边get方法中有一个泛型,可以指定传入的对象的类型,因为我构造函数只有一个,所以会智能输入,可以省略掉
       }

        factory(named("wea_app")) {
              WeatherData(get<NormalData>(named("app")))
        }


          factory(named("wea_appData")){
               WeatherData(get(named("appData")))
          }

   /////////////////////
        /**
         *  把外部的参数param 传递给我们的对象的构造函数ViewData(param) ,
         *   那么我们就要在ViewData实体类中使用这个外部参数param了,可能是调用外部参数param的字段或方法
         *  格式:(param: Any) ->ViewData(param)
         * */

      factory {
          //外部调用的方式,如果是多参数也一样,聪明的同学么应该要学会举一反三了
          (view: View)-> ViewData(view)

      }


///////////////////////////////
         factory {
             ModuleData(get<LibData>())
         }


////////////////////////////////////

        fragment { MyFragment("方明飞啊") }


        /**
         *  从koin.properties文件里读取数据userName
         *
         * */
        factory {
            ProData(getProperty("userName"))//该方法可以设置泛型对象,你已经是一个成熟的程序员了,要学会自己举一反三
        }


   }

/**
 * 新创了一个otherModule,将TimeData注入
 * 通过get<ProData>() 获取已经注入的实体对象ProData
 * 因为ProData在上面中，我已经注入过了，所以通过get（）方式，就可以获取到
 *
 * */

   val  otherModule= module {
      factory {
          TimeData(get<ProData>())
      }
   }

}