package com.padcmyanmar.padcx.helloandroid_padc_x.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentOne
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentTwo

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-09.
 */

class TabPagerAdapter2(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when {
            position == 0 -> return FragmentOne.newInstance("A", "B")
            else -> return FragmentTwo()
        }
    }

}