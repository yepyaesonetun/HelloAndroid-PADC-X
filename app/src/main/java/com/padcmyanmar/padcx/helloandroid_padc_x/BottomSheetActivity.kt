package com.padcmyanmar.padcx.helloandroid_padc_x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.BottomSheetFragment
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class BottomSheetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        // get sheet to set behaviour
        val sheet = BottomSheetBehavior.from(bottom_sheet)

        button.setOnClickListener {
            when {
                sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                    sheet.state = BottomSheetBehavior.STATE_EXPANDED
                    button.text = getString(R.string.btn_lbl_close_sheet)
                }
                else -> {
                    sheet.state = BottomSheetBehavior.STATE_COLLAPSED
                    button.text = getString(R.string.btn_lbl_expand_sheet)
                }
            }
        }

        // bottomsheetDialog
        btnBottomSheetDialog.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
            val sheetDialog = BottomSheetDialog(this)
            sheetDialog.setContentView(view)
            sheetDialog.show()
        }

        // bottom sheet dialog fragment
        btnBottomSheetDialogFragment.setOnClickListener {
            val bottomSheetDialogFragment = BottomSheetFragment()
            bottomSheetDialogFragment.show(supportFragmentManager, bottomSheetDialogFragment.tag)
        }


        // states
        sheet.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // your state
            }

        })


        val value = getString(R.string.template,"AAA")
    }
}
