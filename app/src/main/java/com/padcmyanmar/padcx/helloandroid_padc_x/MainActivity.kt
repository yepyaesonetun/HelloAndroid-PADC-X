package com.padcmyanmar.padcx.helloandroid_padc_x

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val IE_DATA_RETURN = "IE_DATA_RETURN"
    }

    private val REQUEST_CODE_RETURN_DATA = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            // start second activity

//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)


            // static factory method
            startActivity(SecondActivity.newIntent(this))

        }

        // start Second Activity through parsing intent data
        btnStartSecondActivity.setOnClickListener {
            val intentWithExtraData =
                Intent(SecondActivity.newIntent(this, "Text from Main Activity"))
            startActivity(intentWithExtraData)
        }

        /*
        Exercise
        parse integer value to Second Activity
        1. create another static factory method
        2. create constant variable to retrieve nor set
        3. parse data from Main
        4. get and retrieve from Second
        5. show the retrieved data from intent in Second Activity
         */


        // parse and get return intent data
        btnStartSecondFroResult.setOnClickListener {
            startActivityForResult(
                SecondActivity.newIntent(this, "Hello"),
                REQUEST_CODE_RETURN_DATA
            )
        }


        // go to views and view group activity
        btnGoToViewsActivity.setOnClickListener {
            startActivity(ViewsActivity.newIntent(this))
        }

        // go to UI Components activity
        btnGoToUIComponents.setOnClickListener {
            startActivity(UIComponentsActivity.newIntent(this))
        }

        // go to Other Common UI Elements Activity
        btnGoToOtherCommonUIElementsActivity.setOnClickListener {
            startActivity(OtherCommonUiElementsActivity.newIntent(this))
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            requestCode == REQUEST_CODE_RETURN_DATA && resultCode == Activity.RESULT_OK && data != null -> {
                val dataFromSecond = data.getStringExtra(IE_DATA_RETURN)
                textView.text = dataFromSecond
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
