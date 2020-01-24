package com.padcmyanmar.padcx.helloandroid_padc_x.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padcmyanmar.padcx.helloandroid_padc_x.R

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-11.
 */

class BottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }
}