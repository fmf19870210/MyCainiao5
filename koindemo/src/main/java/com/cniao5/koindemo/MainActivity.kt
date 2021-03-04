package com.cniao5.koindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.cniao5.koindemo.factory.FactoryActivity
import com.cniao5.koindemo.fragment.FragActivity
import com.cniao5.koindemo.libmodule.LibModuleActivity
import com.cniao5.koindemo.normal.NormalActivity
import com.cniao5.koindemo.normal.NormalTwoActivity
import com.cniao5.koindemo.other.OtherActivity
import com.cniao5.koindemo.single.SingleActivity
import com.cniao5.koindemo.viewmodel.ViewModelActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {
        findViewById<Button>(R.id.btn_factory).setOnClickListener {
            goActivity(FactoryActivity::class.java)
        }

        findViewById<Button>(R.id.btn_single).setOnClickListener {
            goActivity(SingleActivity::class.java)
        }

        findViewById<Button>(R.id.btn_viewmodel).setOnClickListener {
            goActivity(ViewModelActivity::class.java)
        }

        findViewById<Button>(R.id.btn_normal).setOnClickListener {
            goActivity(NormalActivity::class.java)
        }

        findViewById<Button>(R.id.btn_normal2).setOnClickListener {
            goActivity(NormalTwoActivity::class.java)
        }

        findViewById<Button>(R.id.btn_lib).setOnClickListener {
            goActivity(LibModuleActivity::class.java)
        }

        findViewById<Button>(R.id.btn_frag).setOnClickListener {
            goActivity(FragActivity::class.java)
        }

        findViewById<Button>(R.id.btn_other).setOnClickListener {
            goActivity(OtherActivity::class.java)
        }


    }

    fun goActivity(clz: Class<*>) {
        val intent = Intent(this, clz)
        startActivity(intent)
    }
}