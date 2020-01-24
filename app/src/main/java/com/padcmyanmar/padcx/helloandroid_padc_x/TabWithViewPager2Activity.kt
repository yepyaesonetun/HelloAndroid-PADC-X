package com.padcmyanmar.padcx.helloandroid_padc_x

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.padcmyanmar.padcx.helloandroid_padc_x.adapters.TabPagerAdapter2
import kotlinx.android.synthetic.main.activity_tab_with_view_pager2.*

class TabWithViewPager2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_with_view_pager2)

        val pagerAdapter = TabPagerAdapter2(this)
        pager.adapter = pagerAdapter

        TabLayoutMediator(tabs, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Fragment One"
                    tab.icon = resources.getDrawable(R.drawable.ic_arrow_forward_white_24dp)

                    // badge
                    val badge = tab.orCreateBadge
                    badge.number = 10
                }

                1 -> tab.text = "Fragment Two"
            }
        }.attach()


    }
}
