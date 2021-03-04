package com.cniao5.koindemo.single

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cniao5.koindemo.CSKoinLog
import com.cniao5.koindemo.R
import org.koin.android.ext.android.inject

class SingleActivity : AppCompatActivity(){
    val userData: UserData by inject()
    val userData2: UserData by inject()
    val userData3: UserData by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        userData.userName = "张飞"
        userData.age = 17
        userData.info()

        userData2.userName = "关羽"
        userData2.age = 18
        userData2.info()


        userData3.userName = "刘备"
        userData3.age = 19
        userData3.info()

        CSKoinLog.I(userData.hashCode().toString()) //162288870
        CSKoinLog.I(userData2.hashCode().toString()) //162288870
        CSKoinLog.I(userData3.hashCode().toString())  //162288870

    }

}