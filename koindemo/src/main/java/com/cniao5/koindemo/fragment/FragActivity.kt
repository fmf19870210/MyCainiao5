package com.cniao5.koindemo.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cniao5.koindemo.R
import org.koin.android.ext.android.inject

class FragActivity : AppCompatActivity() {

      val myFragment:MyFragment by inject ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)

     supportFragmentManager.beginTransaction()
         .replace(R.id.mvvm_frame,myFragment)
         .commit()
    }
}