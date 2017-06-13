package com.tytech.ninjawarrior1337.supremewear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.TextView

import com.tytech.ninjawarrior1337.R

class MainActivity : WearableActivity()
{

    private var mTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.text) as TextView

        // Enables Always-on
        setAmbientEnabled()
    }
}
