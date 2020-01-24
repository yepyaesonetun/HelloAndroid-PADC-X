package com.padcmyanmar.padcx.helloandroid_padc_x.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentOne
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentTwo

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-09.
 */

class TabPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when {
            position == 0 -> return FragmentOne.newInstance("A", "B")
            else -> return FragmentTwo()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when {
            position == 0 -> return "Frag One"
            else -> return "Frag Two"
        }
    }
}