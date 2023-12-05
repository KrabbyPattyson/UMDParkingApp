package com.example.umdparkingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button


private lateinit var buttonMap: Button
private lateinit var buttonSettings: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mapButtonClick = findViewById<Button>(R.id.buttonMap)
        var settingsButtonClick = findViewById<Button>(R.id.buttonSettings)

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
    }/*
    fun onMapClick(v:View){

    }
    fun onSettingsClick(v:View){

    }*/
}