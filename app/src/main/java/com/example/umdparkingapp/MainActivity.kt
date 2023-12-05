package com.example.umdparkingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button

private lateinit var buttonMap: Button
private lateinit var buttonSettings: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onMapClick(v:View){

    }
    fun onSettingsClick(v:View){

    }
}