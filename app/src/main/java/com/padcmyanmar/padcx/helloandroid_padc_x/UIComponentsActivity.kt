package com.padcmyanmar.padcx.helloandroid_padc_x

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_uicomponents.*
import java.util.*

class UIComponentsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, UIComponentsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uicomponents)

        tgGuestRoomLight.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                val snackbar =
                    Snackbar.make(
                        buttonView, "Turning on the guest room light.",
                        Snackbar.LENGTH_INDEFINITE
                    )
                snackbar
                    .setAction("Dismiss") {
                        // logic
                        snackbar.dismiss()
                    }

                snackbar.show()

            } else {
                Snackbar.make(
                    buttonView,
                    "Turning off the guest room light.",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
        //tbGuestRoomLight.isChecked();

        sBBrigitness.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {

                //
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })


        // rating bar
        rbHowmuchYouLoveTheRoom.onRatingBarChangeListener =
            OnRatingBarChangeListener { ratingBar, rating, fromUser -> {
                // logic
            }}


        // auto complete text view with simple adapter

        // 1. create autoCompleteTextView in Design View
        // 2. create an array for data collection -> stings.xml
        // 3. create simple adapter for autocompleteTextView
        // 4. setAdapter to your autoCompleteTextView
        val additionalDrinksAdapter: ArrayAdapter<String?> = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_dropdown_item_1line,
            resources.getStringArray(R.array.additional_drinks)
        )


        autoCompleteTextViewAdditionalDrinks.setAdapter(additionalDrinksAdapter)


        btnSelectDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val day = calendar[Calendar.DAY_OF_MONTH]
            val month = calendar[Calendar.MONTH]
            val year = calendar[Calendar.YEAR]
            // date picker dialog
            val picker = DatePickerDialog(
                this,
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    tvSelectedDate.text =
                        dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year
                }, 1978, 3, 21
            )
            picker.show()
        }

        btnSelectTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar[Calendar.HOUR_OF_DAY]
            val minutes = calendar[Calendar.MINUTE]
            // time picker dialog
            val picker = TimePickerDialog(
                this,
                OnTimeSetListener { tp, sHour, sMinute ->
                    tvSelectedTime.text = "$sHour:$sMinute"
                },
                hour,
                minutes,
                true
            )
            picker.show()
        }
    }
}
