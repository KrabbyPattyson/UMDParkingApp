package com.example.umdparkingapp

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class Settings {
    private var gameday : Boolean = false
    private var service : Boolean = false
    private var lot : String = "None"

    constructor(gameday : Boolean, service : Boolean, lot : String) {
        setGameday( gameday )
        setService( service )
        setLot( lot )
    }

    constructor( context: Context) {
        var pref : SharedPreferences = context.getSharedPreferences( context.packageName + "_preferences",
            Context.MODE_PRIVATE )
        setGameday( pref.getBoolean(GAMEDAY, false ))
        setService( pref.getBoolean(SERVICE, false))
        setLot(pref.getString(LOT, "None").toString())
    }

    fun setGameday(g : Boolean) {
        gameday = g
    }

    fun getGameday() : Boolean {
        return gameday
    }

    fun setService(s : Boolean) {
        service = s
    }

    fun getService() : Boolean {
        return service
    }

    fun setLot(l : String) {
        lot = l
    }

    fun getLot() : String {
        return lot
    }

    fun setPreferences(context: Context){
        var pref : SharedPreferences = context.getSharedPreferences( context.packageName + "_preferences",
            Context.MODE_PRIVATE )

        var editor : SharedPreferences.Editor = pref.edit()
        editor.putBoolean(GAMEDAY, gameday)
        editor.putBoolean(SERVICE, service )
        editor.putString(LOT, lot)
        editor.commit()
    }

    fun sayPreferences() {
        Log.w("MainActivity", "You're preferences are: \nGameday: ${gameday}\nService/Faculty: ${service}\nLot: $lot")
    }

    // This holds the keys to the persistent data for other activities to use
    companion object {
        private const val GAMEDAY = "Gameday"
        private const val HANDICAP = "Handicap"
        private const val SERVICE = "Service/Faculty"
        private const val LOT = "Lot location"
    }
}