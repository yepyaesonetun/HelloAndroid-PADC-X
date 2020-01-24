package com.padcmyanmar.padcx.helloandroid_padc_x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentOne
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentThree
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentTwo
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_home -> {
                        openFragment(FragmentOne.newInstance("A","B"))
                        return true
                    }
                    R.id.navigation_notifications -> {
                        openFragment(FragmentTwo())
                        return true
                    }
                    R.id.navigation_profile -> {
                        openFragment(FragmentThree())
                        return true
                    }
                }
                return false
            }

        })

    }


    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flBottomNavigationContainer, fragment)
            .commit()
    }


}
