package com.example.umdparkingapp

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
            Log.w("MainActivity", "Sent to MapActivity view?")
        }


        settingsButtonClick.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            Log.w("MainActivity", "Sent to SettingsActivity view?")
        }
    }
}