package com.padcmyanmar.padcx.helloandroid_padc_x

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.padcmyanmar.padcx.helloandroid_padc_x.fragments.FragmentOne
import kotlinx.android.synthetic.main.activity_navigation_view.*

class NavigationViewActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NavigationViewActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_view)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.color_full_white))

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )

        toggle.syncState()



        navView.setNavigationItemSelectedListener(this)


    }

    override fun onBackPressed() {

        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_camera -> {

                // logic
                Toast.makeText(this, "This is Camera", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.nav_gallery -> Toast.makeText(this, "This is Gallery", Toast.LENGTH_SHORT).show()
            R.id.nav_slideshow -> Toast.makeText(
                this,
                "This is SlideShow",
                Toast.LENGTH_SHORT
            ).show()
            R.id.nav_manage -> Toast.makeText(this, "This is Manage", Toast.LENGTH_SHORT).show()
            R.id.nav_send -> supportFragmentManager.beginTransaction()
                .replace(R.id.flContainerNav, FragmentOne.newInstance("A", "B"))
                .commit()
        }
        return true
    }
}
