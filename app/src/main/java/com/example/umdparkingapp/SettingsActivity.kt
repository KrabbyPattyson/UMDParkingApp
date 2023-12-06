package com.example.umdparkingapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
// Project 4 game.kt is the one with persistent data aka SharedPreferences that we will use here

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    fun endActivity(v: View){
        finish()
    }
}