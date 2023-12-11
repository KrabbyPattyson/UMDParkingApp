package com.example.umdparkingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

private lateinit var mapButtonClick: Button
private lateinit var settingsButtonClick: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapButtonClick = findViewById<Button>(R.id.buttonMap)
        settingsButtonClick = findViewById<Button>(R.id.buttonSettings)

        // This is the event handler to send users to the Map activity
        mapButtonClick.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
            overridePendingTransition( R.anim.slide_left, 0, 0 )
            Log.w("MainActivity", "Sent to MapActivity view?")
        }

        // This is the event handler to send users to the Settings activity
        settingsButtonClick.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition( R.anim.slide_left, 0, 0 )
            Log.w("MainActivity", "Sent to SettingsActivity view?")
        }

        // Create a Settings object
        settings = Settings(this)
        settings.sayPreferences()
    }

    override fun onResume() {
        super.onResume()
        settings.sayPreferences()
    }

    companion object {
        lateinit var settings : Settings
    }
}