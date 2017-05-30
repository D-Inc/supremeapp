package com.tytech.ninjawarrior1337.supremeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import io.kimo.konamicode.KonamiCode;
import io.kimo.konamicode.KonamiCodeLayout;

import static android.R.attr.bottom;
import static android.R.attr.content;
import static android.R.attr.fragment;
import static android.R.attr.top;
import static android.R.attr.visibility;
import static android.R.attr.visible;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new KonamiCode.Installer(MainActivity.this).on(this).callback(new KonamiCodeLayout.Callback()
        {
            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Vert Dnag", Toast.LENGTH_SHORT).show();
            }
        }).install();

        final Button botomPortal;
        botomPortal = (Button) findViewById(R.id.bottomPortal);

        final Button topPortal;
        topPortal = (Button) findViewById(R.id.topPortal);

        final ImageView finegear;
        finegear = (ImageView) findViewById(R.id.finegear);
        finegear.setVisibility(View.INVISIBLE);

        botomPortal.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        finegear.setVisibility(View.VISIBLE);
                        break;
                    case MotionEvent.ACTION_UP:
                        finegear.setVisibility(View.INVISIBLE);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.settings)
        {
            Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(myIntent);
        }
        return true;
    }
}
