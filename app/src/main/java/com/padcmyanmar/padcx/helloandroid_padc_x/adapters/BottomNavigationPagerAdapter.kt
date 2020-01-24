package com.padcmyanmar.padcx.helloandroid_padc_x.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentOne
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentThree
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentTwo

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-10.
 */

class BottomNavigationPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return FragmentOne.newInstance("A", "B")
            }
            1 -> return FragmentTwo()
            2 -> return FragmentThree()
            else -> return FragmentOne.newInstance("A", "B")
        }

    }
}