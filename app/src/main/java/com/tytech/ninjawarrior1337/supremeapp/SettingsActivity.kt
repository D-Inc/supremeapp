package com.tytech.ninjawarrior1337.supremeapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewCompat.setBackgroundTintList
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.OnColorChangedListener
import com.flask.colorpicker.OnColorSelectedListener
import com.flask.colorpicker.builder.ColorPickerClickListener
import com.flask.colorpicker.builder.ColorPickerDialogBuilder
import com.jrummyapps.android.colorpicker.ColorPickerDialog
import com.jrummyapps.android.colorpicker.ColorPickerDialogListener
import com.tytech.ninjawarrior1337.R
//import com.tytech.ninjawarrior1337.R.id.settings
//import com.tytech.ninjawarrior1337.R.id.topPortal
//import com.tytech.ninjawarrior1337.R.raw.portal

/**
 * Created by ninjawarrior1337 on 6/3/2017.
 */

class SettingsActivity : AppCompatActivity(), ColorPickerDialogListener
{
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        val PREFS_NAME = "SupremeAppPrefs"
        var pref: SharedPreferences = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        pref.edit().putString("topPortalC", "#" + Integer.toHexString(R.color.defaultTPortal)).apply()
        pref.edit().putString("bottomPortalC", "#" + Integer.toHexString(R.color.defaultBPortal)).apply()

        val topPortalCS: Button
        topPortalCS = findViewById(R.id.TopPortalCS) as Button
        setBackgroundTintList(findViewById(R.id.TopPortalCS), ColorStateList.valueOf(Color.parseColor(pref.getString("topPortalC", Integer.toHexString(R.color.defaultTPortal)))))

        val bottomPortalCS: Button
        bottomPortalCS = findViewById(R.id.BottomPortalCS) as Button
        setBackgroundTintList(findViewById(R.id.BottomPortalCS), ColorStateList.valueOf(Color.parseColor(pref.getString("bottomPortalC", Integer.toHexString(R.color.defaultBPortal)))))

        val PortalCReset: Button
        PortalCReset = findViewById(R.id.PortalReset) as Button

        PortalCReset.setOnClickListener {
            pref.edit().putString("topPortalC","#" + Integer.toHexString(R.color.defaultTPortal)).apply()
            pref.edit().putString("bottomPortalC","#" + Integer.toHexString(R.color.defaultBPortal)).apply()
            setBackgroundTintList(findViewById(R.id.TopPortalCS),ColorStateList.valueOf(resources.getColor(R.color.defaultTPortal)))
            setBackgroundTintList(findViewById(R.id.BottomPortalCS), ColorStateList.valueOf(resources.getColor(R.color.defaultBPortal)))
        }

        topPortalCS.setOnClickListener { topPortalCSM(Color.parseColor(pref.getString("topPortalC", Integer.toHexString(R.color.defaultTPortal)))) }
        bottomPortalCS.setOnClickListener { bottomPortalCSM(Color.parseColor(pref.getString("bottomPortalC", Integer.toHexString(R.color.defaultBPortal)))) }


    }

    fun topPortalCSM(baseColor: Int)
    {
        ColorPickerDialog
                .newBuilder()
                .setColor(baseColor)
                .setDialogType(ColorPickerDialog.TYPE_CUSTOM)
                .setDialogId(0)
                .setShowAlphaSlider(true)
                .show(this)
    }

    fun bottomPortalCSM(baseColor: Int)
    {
        ColorPickerDialog
                .newBuilder()
                .setColor(baseColor)
                .setDialogType(ColorPickerDialog.TYPE_CUSTOM)
                .setDialogId(1)
                .setShowAlphaSlider(true)
                .show(this)
    }

    override fun onColorSelected(dialogid: Int, color: Int)
    {
        val PREFS_NAME = "SupremeAppPrefs"
        var pref: SharedPreferences = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        when (dialogid)
        {
            0 -> {
                setBackgroundTintList(findViewById(R.id.TopPortalCS), ColorStateList.valueOf(color))
                pref.edit().putString("topPortalC", "#" + Integer.toHexString(color)).apply()
            }

            1 -> {
                setBackgroundTintList(findViewById(R.id.BottomPortalCS), ColorStateList.valueOf(color))
                pref.edit().putString("bottomPortalC", "#" + Integer.toHexString(color)).apply()
            }
        }
    }

    override fun onDialogDismissed(p0: Int) {

    }

    override fun onRestart() {
        super.onRestart()
        val PREFS_NAME = "SupremeAppPrefs"
        var pref: SharedPreferences = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        setBackgroundTintList(findViewById(R.id.TopPortalCS), ColorStateList.valueOf(Color.parseColor(pref.getString("topPortalC", Integer.toHexString(R.color.defaultTPortal)))))
        setBackgroundTintList(findViewById(R.id.BottomPortalCS), ColorStateList.valueOf(Color.parseColor(pref.getString("bottomPortalC", Integer.toHexString(R.color.defaultBPortal)))))

    }


}
