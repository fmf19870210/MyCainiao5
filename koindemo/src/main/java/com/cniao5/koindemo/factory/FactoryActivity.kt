package com.cniao5.koindemo.factory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cniao5.koindemo.CSKoinLog
import com.cniao5.koindemo.R
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject


/**
* 大家可以看到就很像new了一个新的对象Person一样,好,注入完了之后,
 * 就可以在Activity中调用了,我在FactoryActivity中调用它.
*
* */
class FactoryActivity : AppCompatActivity() {
    //调用方式有大致下面几种,后面会再说到
    val person: Person by inject()//方法一
    val person2 by inject<Person>()//方法二



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_factory)
        val person3 = get<Person>()//方法三

          person.speak()
          person2.speak()
          person3.speak()
         CSKoinLog.I(person.hashCode().toString()) //142337213
         CSKoinLog.I(person2.hashCode().toString()) //60828338
         CSKoinLog.I(person3.hashCode().toString()) //266377731
    }

}