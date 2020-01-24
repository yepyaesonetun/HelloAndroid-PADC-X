package com.padcmyanmar.padcx.helloandroid_padc_x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_static_fragment.*

class StaticFragmentActivity : BaseFragmentActivity() {
    override fun onTapButtonHello() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_fragment)

        setSupportActionBar(toolbar)
    }
}
