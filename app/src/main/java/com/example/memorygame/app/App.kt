package com.example.memorygame.app

import android.app.Application
import android.net.Uri
import com.example.memorygame.R
import com.example.memorygame.utils.Media
import java.io.DataInputStream


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Media.getInstance()
//        Media.media?.play(applicationContext, R.raw.)
    }
}