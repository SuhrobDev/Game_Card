package com.example.memorygame.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPreferencesHelper (var context: Context){

    private var preferences:SharedPreferences = context.getSharedPreferences("APP_PREFS_NAME",MODE_PRIVATE)

    private var editor:SharedPreferences.Editor = preferences.edit()

    fun setLevel (level:Int){
        editor = preferences.edit()
        editor.putInt("LEVEL",level)
        editor.apply()
    }

    fun getLevel() = preferences.getInt("LEVEL", 0)

    fun setTime(time:Int){
        editor.putInt("TIME",time)
        editor.apply()
    }

    fun getTime() = preferences.getInt("TIME",0)
}