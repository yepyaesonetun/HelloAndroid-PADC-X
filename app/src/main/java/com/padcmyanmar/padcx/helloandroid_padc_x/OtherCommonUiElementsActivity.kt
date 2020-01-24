package com.padcmyanmar.padcx.helloandroid_padc_x

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other_common_ui_elements.*

class OtherCommonUiElementsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, OtherCommonUiElementsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_common_ui_elements)

        setSupportActionBar(toolbar)


        // go to tabLayoutActivity
        btnGoToTabLayoutActivity.setOnClickListener {
            startActivity(TabLayoutActivity.newIntent(this))
        }

        // go to collapsing toolbar view
        btnGoToCollpasingToolbarActivity.setOnClickListener {
            startActivity(CollapsingToolbarActivity.newIntent(this))
        }


        // go to navigation view
        btnGoToNavigationView.setOnClickListener {
            startActivity(NavigationViewActivity.newIntent(this))
        }

        // go to constraint layout activity
        btnGoToConstraintLayout.setOnClickListener {
            startActivity(Intent(this, ConstraintLayoutActivity::class.java))
        }

        // go to common ui element examples
        btnGoToCommonUIElementsExample.setOnClickListener {
            startActivity(CommonUIElementsExamplesActivity.newIntent(this))
        }
    }
}
