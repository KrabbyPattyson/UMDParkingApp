package com.example.umdparkingapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.LinearLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

// Project 4 game.kt is the one with persistent data aka SharedPreferences that we will use here

class SettingsActivity : AppCompatActivity() {
    private lateinit var adView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //createAd( )
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
}