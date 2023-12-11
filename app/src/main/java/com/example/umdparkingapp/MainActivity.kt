package com.example.umdparkingapp

import android.app.ActivityOptions
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button


private lateinit var mapButtonClick: Button
private lateinit var settingsButtonClick: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapButtonClick = findViewById<Button>(R.id.buttonMap)
        settingsButtonClick = findViewById<Button>(R.id.buttonSettings)

        mapButtonClick.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
            overridePendingTransition( R.anim.slide_left, 0, 0 )
            Log.w("MainActivity", "Sent to MapActivity view?")
        }

        // Create a Settings app
        settings = Settings(this)
        settings.sayPreferences()

        settingsButtonClick.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition( R.anim.slide_left, 0, 0 )
            Log.w("MainActivity", "Sent to SettingsActivity view?")
        }
    }

    override fun onResume() {
        super.onResume()
        settings.sayPreferences()
    }

    companion object {
        lateinit var settings : Settings
    }
}