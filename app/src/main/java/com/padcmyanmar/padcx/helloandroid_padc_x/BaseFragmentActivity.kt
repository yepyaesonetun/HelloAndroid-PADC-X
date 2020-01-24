package com.padcmyanmar.padcx.helloandroid_padc_x

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padcx.helloandroid_padc_x.delegates.FragmentOneDelegate

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-10.
 */

abstract class BaseFragmentActivity : AppCompatActivity(), FragmentOneDelegate {
    abstract override fun onTapButtonHello()

}