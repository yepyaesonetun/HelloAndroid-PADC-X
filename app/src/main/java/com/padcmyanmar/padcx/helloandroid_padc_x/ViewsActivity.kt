package com.padcmyanmar.padcx.helloandroid_padc_x

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_views.*
import java.util.*

class ViewsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ViewsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.color_full_white))

        // set text value from string resource
        tvHello.text = resources.getText(R.string.lbl_hello_text_view)

        // set image from drawable resource
//        ivGreeting.setImageDrawable(resources.getDrawable(R.drawable.holadios)) // deprecated
        ivGreeting.setImageResource(R.drawable.holadios)


        // random greeting while btn click
        val greetingImages = intArrayOf(
            R.drawable.greetings_01,
            R.drawable.greetings_02,
            R.drawable.greetings_03,
            R.drawable.greetings_04,
            R.drawable.greetings_05,
            R.drawable.greetings_06
        )

        btnRandomGreeting.setOnClickListener {
            val random = Random()
            val index = random.nextInt(greetingImages.size)
            ivGreeting.setImageResource(greetingImages[index])
        }


        // image Button with snack bar
        // snack bar action, DURATIONs
//        imageButton.setOnClickListener {
//            val snackbar = Snackbar.make(it, "Hello PADC Snackbar", Snackbar.LENGTH_INDEFINITE)
//
//            snackbar
//                .setAction("Dismiss") {
//                    snackbar.dismiss()
//                }
//            snackbar.show()
//        }


        // editText get text
        val textValue = editText.text.toString()

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Title")
        alertDialog.setMessage("Content")
        alertDialog.setPositiveButton("OK") { dialog, _ ->
            dialog.cancel()
        }


        imageButton.setOnClickListener {
            alertDialog.show()

            /*
            Exercise
            1. show alert dialog when you pressed imageButton
            2. dialog content should be the text value from editText
            3. set positive button -> click -> close activity
            4. set negative button -> click -> dialog dismiss
             */
        }


        // checkbox check state and show dialog
        btnCheckFruit.setOnClickListener {

            var selectedFruits = when {
                cbBanana.isChecked -> resources.getString(R.string.cb_txt_banana)
                else -> ""
            }
            selectedFruits += when {
                cbApple.isChecked -> resources.getString(R.string.cb_txt_apple)
                else -> ""
            }
            selectedFruits += when {
                cbMango.isChecked -> resources.getString(R.string.cb_txt_mango)
                else -> ""
            }

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle(getString(R.string.alert_title_fruit))
            dialog.setMessage("Fruits you selected: $selectedFruits")
            dialog.show()
        }


        // radio check and show Toast Message
        radioMale.setOnCheckedChangeListener { _: CompoundButton, _: Boolean ->
            Toast.makeText(this, "Checked Male", Toast.LENGTH_SHORT).show()
        }

        radioFemale.setOnCheckedChangeListener { _: CompoundButton, _: Boolean ->
            Toast.makeText(this, "Checked Female", Toast.LENGTH_SHORT).show()
        }

    }
}
