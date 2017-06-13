package com.tytech.ninjawarrior1337.supremeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.larvalabs.svgandroid.SVGParser
import io.kimo.konamicode.KonamiCode
import android.R.raw
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.ViewCompat.setBackgroundTintList
import android.util.Log
import android.view.*
import com.larvalabs.svgandroid.SVG
import com.tytech.ninjawarrior1337.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        KonamiCode.Installer(this@MainActivity).on(this).callback { Toast.makeText(this@MainActivity, "Vert Dnag", Toast.LENGTH_SHORT).show() }.install()

        val botomPortalB: Button
        botomPortalB = findViewById(R.id.bottomPortal) as Button

        val topPortalB: Button
        topPortalB = findViewById(R.id.topPortal) as Button

        val PREFS_NAME = "SupremeAppPrefs"
        var pref = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        pref.edit().putString("topPortalC", "#" + Integer.toHexString(R.color.defaultTPortal)).apply()
        pref.edit().putString("bottomPortalC", "#" + Integer.toHexString(R.color.defaultBPortal)).apply()


        val finegear: ImageView
        finegear = findViewById(R.id.finegear) as ImageView
        finegear.visibility = View.INVISIBLE

        botomPortalB.setOnTouchListener { v, event ->
            when (event.action)
            {
                MotionEvent.ACTION_DOWN -> findViewById(R.id.finegear).visibility = View.VISIBLE
                MotionEvent.ACTION_UP -> findViewById(R.id.finegear).visibility = View.INVISIBLE
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settings) {
            val myIntent = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(myIntent)
        }
        return true
    }

//    public override fun onResume()
//    {
//        super.onResume()
//        val PREFS_NAME = "SupremeAppPrefs"
//        var pref = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
//        setBackgroundTintList(findViewById(R.id.topPortal), ColorStateList.valueOf(Color.parseColor(pref.getString("topPortalC", Integer.toHexString(R.color.defaultTPortal)))))
//        setBackgroundTintList(findViewById(R.id.bottomPortal), ColorStateList.valueOf(Color.parseColor(pref.getString("bottomPortalC", Integer.toHexString(R.color.defaultBPortal)))))
//
//    }
    public override fun onRestart()
    {
        super.onRestart()

        val PREFS_NAME = "SupremeAppPrefs"
        var pref = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        setBackgroundTintList(findViewById(R.id.topPortal), ColorStateList.valueOf(Color.parseColor(pref.getString("topPortalC", Integer.toHexString(R.color.defaultTPortal)))))
        setBackgroundTintList(findViewById(R.id.bottomPortal), ColorStateList.valueOf(Color.parseColor(pref.getString("bottomPortalC", Integer.toHexString(R.color.defaultBPortal)))))

        //Log.d("vertd", pref.getInt("topPortalC", R.color.defaultTPortal).toString())

    }

    override fun onStop() {
        super.onStop()
        val PREFS_NAME = "SupremeAppPrefs"
        var pref = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}
