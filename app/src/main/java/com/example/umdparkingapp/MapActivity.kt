package com.example.umdparkingapp

import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        var fragment : SupportMapFragment =
            supportFragmentManager.findFragmentById( R.id.map ) as SupportMapFragment
        fragment.getMapAsync( this )
    }

    override fun onMapReady(p0: GoogleMap) {
        Log.w( "MainActivity", "Inside onMapReady" )
        map = p0
        var umd : LatLng = LatLng( 38.9860, -76.9451 )

        // add a circle

        var options : CircleOptions = CircleOptions( )
        options.center( umd )
        options.radius( 100.0 )
        options.strokeWidth( 10.0f )
        options.strokeColor( Color.RED )
        map.addCircle( options )

        // add a marker
        // var marker : MarkerOptions = MarkerOptions( )
        // marker.position( whiteHouse )
        // marker.title( "White House" )
        // marker.snippet( "How is the food?" )
        // map.addMarker( marker )

        map.addMarker( MarkerOptions( ).position( umd ).title( "UMD").snippet( "How is the food?" ) )

        var camera : CameraUpdate = CameraUpdateFactory.newLatLngZoom( umd, 15.0f )
        map.moveCamera( camera )

        // do some geocoding
        //geocode()
    }

    fun geocode( ) {
        var geocoder : Geocoder = Geocoder( this )
        var address : String = "xyz bad address"
        var handler : GeocodeHandler = GeocodeHandler()
        geocoder.getFromLocationName( address, 5, handler )
    }

    inner class GeocodeHandler : Geocoder.GeocodeListener {
        override fun onGeocode(p0: MutableList<Address>) {
            if( p0 != null && p0.size > 0 ) {
                Log.w( "MainActivity", "we have results" )
                var firstResult : Address = p0.get( 0 )
                var lat : Double = firstResult.latitude
                var long : Double = firstResult.longitude
                Log.w( "MainActivity", "( lat, long ) is " + lat + ", " + long )
            }
        }

        override fun onError(errorMessage: String?) {
            super.onError(errorMessage)
            Log.w( "MainActivity", "error: " + errorMessage )
        }
    }
}