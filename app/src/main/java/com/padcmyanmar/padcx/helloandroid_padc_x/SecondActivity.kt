package com.padcmyanmar.padcx.helloandroid_padc_x

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padcx.helloandroid_padc_x.MainActivity.Companion.IE_DATA_RETURN
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {

        const val IE_DATA_TO_DISPLAY = "IE_DATA_TO_DISPLAY"

        fun newIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java)
        }

        fun newIntent(context: Context, dataToDisplay: String): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(IE_DATA_TO_DISPLAY, dataToDisplay)
            return intent
        }
    }


    val REQUEST_IMAGE_GET = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        // go to main activity
        //        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
        btnBack.setOnClickListener {
            finish()
        }

        // choose image
        btnSelectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_IMAGE_GET)
        }


        // web
        btnGoGoogle.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }

        // show direction on map
        btnShowDirection.setOnClickListener {
            val openInMapPrefix = "http://maps.google.com/maps?daddr="
            val uriToOpen = "$openInMapPrefix PADC Myanmar"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(uriToOpen)
            when {
                intent.resolveActivity(packageManager) != null -> {
                    startActivity(intent)
                }
            }

        }


        // get intent extra data and display
        val data = intent.getStringExtra(IE_DATA_TO_DISPLAY)
        tvDataFromMain.text = data


        // return to main with data
        btnReturnToMain.setOnClickListener {
            val intent = Intent()
            intent.putExtra(IE_DATA_RETURN, "Data from Second Activity")
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when {
            requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK && data != null -> {
                val fullPhotoUri: Uri? = data.data
                ivSelectedImage.setImageURI(fullPhotoUri)
            }
        }
    }
}
