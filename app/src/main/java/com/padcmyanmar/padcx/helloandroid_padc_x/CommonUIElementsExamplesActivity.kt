package com.padcmyanmar.padcx.helloandroid_padc_x

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_common_uielements_examples.*

class CommonUIElementsExamplesActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CommonUIElementsExamplesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_uielements_examples)

        // listener for chip
        chipCheckable.setOnCheckedChangeListener { compoundButton, b ->
            when (b) {
                true -> {
                    Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
