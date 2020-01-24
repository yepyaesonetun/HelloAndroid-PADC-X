package com.padcmyanmar.padcx.helloandroid_padc_x

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padcx.helloandroid_padc_x.delegates.FragmentOneDelegate
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentOne
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentTwo
import kotlinx.android.synthetic.main.activity_dynamic_fragment.*

class DynamicFragmentActivity : BaseFragmentActivity(){

    override fun onTapButtonHello() {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment)

        btnShowFragmentOne.setOnClickListener {
            // show fragment one in frame layout container
            showFragmentOne()
        }

        btnShowFragmentTwo.setOnClickListener {
            // show fragment two in frame layout container
            showFragmentTwo()
        }

        // with transition
        btnShowFragmentOneWithTransition.setOnClickListener { showFragmentOneWithTransition() }

        // with backstack
        btnShowFragmentTwoBackStack.setOnClickListener { showFragmentTwoWithBackStack() }

    }

    private fun showFragmentTwoWithBackStack() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, FragmentTwo())
            .addToBackStack(null)
            .commit()
    }

    private fun showFragmentOneWithTransition() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, FragmentOne.newInstance("Arg One", "Arg Two"))
            .setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit, R.anim.enter, R.anim.exit)
            .commit()
    }

    fun showFragmentOne() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, FragmentOne.newInstance("showFragmentOne", "Param 2"))
            .commit()
    }

    fun showFragmentTwo() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, FragmentTwo())
            .commit()
    }

}
