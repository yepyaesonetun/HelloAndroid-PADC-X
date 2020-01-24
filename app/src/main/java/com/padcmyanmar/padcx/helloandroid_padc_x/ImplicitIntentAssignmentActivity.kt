package com.padcmyanmar.padcx.helloandroid_padc_x

import android.annotation.SuppressLint
import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CalendarContract.Events
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_implicit_intent_assignment.*


class ImplicitIntentAssignmentActivity : AppCompatActivity() {

    private val REQUEST_VIDEO_CAPTURE = 1

    private val REQUEST_SELECT_PHONE_NUMBER = 11


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent_assignment)

        btnSetTimer.setOnClickListener {
            val seconds = 120
            val alarmIntent = Intent(AlarmClock.ACTION_SET_ALARM)
            alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Hello")
            alarmIntent.putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            alarmIntent.putExtra(AlarmClock.EXTRA_SKIP_UI, true)

            if (alarmIntent.resolveActivity(packageManager) != null) {
                startActivity(alarmIntent)
            }
        }


        // add calendar event by implicit intent
        btnAddEvent.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT).apply {
                data = Events.CONTENT_URI
                putExtra(Events.TITLE, "Assignment One")
                putExtra(Events.EVENT_LOCATION, "PADC Myanmar")
                putExtra(
                    Events.DESCRIPTION,
                    "Set by the Implicit intent for showing the result of Assignment One"
                )
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }


        // phone call with implicit intent
        btnCallPhone.setOnClickListener {

            val phoneNumber = "09256443072"
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel: $phoneNumber")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        // Capture
        btnCapture.setOnClickListener {
            Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { takeVideoIntent ->
                takeVideoIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE)
                }
            }

//            val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivityForResult(intent, REQUEST_VIDEO_CAPTURE)
//            }
        }

        // select contact
        btnSelectContactAndShowSelected.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK).apply {
                type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER)
            }
        }

        // web search
        btnWebSearch.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "Android")
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK && data != null -> {
                val videoUri: Uri? = data?.data
                videoView.setVideoURI(videoUri)
                videoView.start()
            }

            requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == Activity.RESULT_OK && data != null -> {

                val contactData: Uri? = data.data
//                val cursor: Cursor = managedQuery(contactData, null, null, null, null)
//                cursor.moveToFirst()

                contentResolver.query(contactData!!, null, null, null, null)
                    .use { cursor ->
                        cursor!!.moveToFirst()

                        val numberIndex =
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                        val displayNameIndex =
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                        tvSelectedValue.text =
                            "Number :: ${cursor.getString(numberIndex)}\nDisplay Name :: ${cursor.getString(
                                displayNameIndex
                            )}\n"
                    }
            }

        }
    }
}
