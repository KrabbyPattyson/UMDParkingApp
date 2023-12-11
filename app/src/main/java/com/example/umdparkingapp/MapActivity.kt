package com.example.umdparkingapp

import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.SearchView
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map : GoogleMap
    //private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        settings = Settings(this)
        settings.sayPreferences()

        val fragment : SupportMapFragment =
            supportFragmentManager.findFragmentById( R.id.map ) as SupportMapFragment
        fragment.getMapAsync( this )

        //searchView = findViewById<SearchView>(R.id.searchView)

    }


    override fun onMapReady(p0: GoogleMap) {
        Log.w( "MainActivity", "Inside onMapReady" )
        map = p0
        var umd : LatLng = LatLng( 38.9860, -76.9451 )
        var lot1: LatLng = LatLng(38.988127,-76.949295)
        var lot2: LatLng = LatLng(38.994227,-76.948361)
        var lot3: LatLng = LatLng(38.988189,-76.953328)
        var lot4: LatLng = LatLng(38.985521,-76.954336)
        var lot5: LatLng = LatLng(38.985095,-76.954872)
        val allLots: List<Pair<Double, Double>> = listOf(
            Pair(38.988127,-76.949295),
            Pair(38.994227,-76.948361),
            Pair(38.988189,-76.953328),
            Pair(38.985521,-76.954336),
            Pair(38.985095,-76.954872)
        )

        // Place a marker on the user's parking permit lot
        if(MainActivity.settings.getLot() == "Lot 1"){
            map.addMarker(MarkerOptions().position(lot1).title("Lot 1").snippet("Your parking permit is here"))
        } else if(MainActivity.settings.getLot() == "Lot 2"){
            map.addMarker(MarkerOptions().position(lot2).title("Lot 2").snippet("Your parking permit is here"))
        } else if(MainActivity.settings.getLot() == "Lot 3"){
            map.addMarker(MarkerOptions().position(lot3).title("Lot 3").snippet("Your parking permit is here"))
        } else if(MainActivity.settings.getLot() == "Lot 4"){
            map.addMarker(MarkerOptions().position(lot4).title("Lot 4").snippet("Your parking permit is here"))
        } else if(MainActivity.settings.getLot() == "Lot 5"){
            map.addMarker(MarkerOptions().position(lot5).title("Lot 5").snippet("Your parking permit is here"))
        }


        // add a circle

        var options : CircleOptions = CircleOptions( )

        for (loc in allLots) {
            options.center(LatLng(loc.first, loc.second))
            options.radius(100.0)
            options.strokeWidth(10.0f)
            options.strokeColor(Color.RED)
            map.addCircle(options)
        }


        // add a marker
        // var marker : MarkerOptions = MarkerOptions( )
        // marker.position( whiteHouse )
        // marker.title( "White House" )
        // marker.snippet( "How is the food?" )
        // map.addMarker( marker )

        map.addMarker( MarkerOptions( ).position( umd ).title( "UMD").snippet( "How is the food?" ) )

        var camera : CameraUpdate = CameraUpdateFactory.newLatLngZoom( umd, 15.0f )
        map.moveCamera( camera )
    }

    companion object {
        lateinit var settings : Settings
    }
}