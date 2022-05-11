package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memorygame.controller.extention
import com.example.memorygame.ui.SplashFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        extention.init(R.id.container,supportFragmentManager)
        extention.controller?.startMainFragment(SplashFragment())
    }
}