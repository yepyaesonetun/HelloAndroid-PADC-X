package com.padcmyanmar.padcx.helloandroid_padc_x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.padcx.helloandroid_padc_x.adapters.BottomNavigationPagerAdapter
import kotlinx.android.synthetic.main.activity_bottom_navigation_with_view_pager.*

class BottomNavigationWithViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_with_view_pager)

        val pagerAdapter = BottomNavigationPagerAdapter(this)
        viewPager.adapter = pagerAdapter


        viewPager.currentItem = 0

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottomNavigation.selectedItemId = R.id.navigation_home
                    1 -> bottomNavigation.selectedItemId = R.id.navigation_notifications
                    2 -> bottomNavigation.selectedItemId = R.id.navigation_profile
                }
            }

        })


        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_home -> {
                        viewPager.currentItem = 0
                        return true
                    }
                    R.id.navigation_notifications -> {
                        viewPager.currentItem = 1
                        return true
                    }
                    R.id.navigation_profile -> {
                        viewPager.currentItem = 2
                        return true
                    }
                }
                return false
            }

        })

    }
}
