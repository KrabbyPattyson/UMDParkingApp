package com.example.umdparkingapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.appcompat.widget.SwitchCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import android.widget.Toast
import android.widget.AdapterView
import android.widget.ArrayAdapter

// Project 4 game.kt is the one with persistent data aka SharedPreferences that we will use here

class SettingsActivity : AppCompatActivity() {
    private lateinit var adView : AdView
    private lateinit var gamedaySwitch : SwitchCompat
    private lateinit var handicapSwitch : SwitchCompat
    private lateinit var serviceSwitch : SwitchCompat
    private lateinit var lotName : Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        gamedaySwitch = findViewById(R.id.gameDaySwitch)
        handicapSwitch = findViewById(R.id.handicapSwitch)
        serviceSwitch = findViewById(R.id.serviceSwitch)
        lotName = findViewById(R.id.spinner)

        lotName.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Handle the item selection here
                var newPos = position+1
                showToast("Parking Permit Selected: Lot$newPos")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing here
            }
        }

        //createAd( )
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun createAd( ) {
        Log.w("SettingsActivity", "in createAd")
        adView = AdView( this )
        var adSize : AdSize = AdSize( AdSize.FULL_WIDTH, AdSize.AUTO_HEIGHT )
        adView.setAdSize( adSize )

        var adUnitId : String = // "ca-app-pub-3940256099942544/1033173712"
            "ca-app-pub-3940256099942544/3347511713"
        adView.adUnitId = adUnitId

        var builder : AdRequest.Builder = AdRequest.Builder( )
        builder.addKeyword( "parking" ).addKeyword( "car" )
        var request : AdRequest = builder.build()

        /*// add adView to linear layout
        var layout : LinearLayout = findViewById( R.id.adView )
        layout.addView( adView )
*/
        // load the ad
        adView.loadAd( request )
    }
    fun endActivity(v: View){
        finish()
    }

    fun saveSettings(v: View) {
        MainActivity.settings.setGameday(gamedaySwitch.isChecked)
        MainActivity.settings.setHandicap(handicapSwitch.isChecked)
        MainActivity.settings.setService(serviceSwitch.isChecked)
        MainActivity.settings.setLot(lotName.selectedItem.toString())
        MainActivity.settings.setPreferences(this)
        finish()
    }


}