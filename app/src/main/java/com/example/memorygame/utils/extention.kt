package com.example.memorygame.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.memorygame.R


fun FragmentActivity.startMainFragment(fr: Fragment) {
    val manager = this.supportFragmentManager
    val transaction = manager.beginTransaction()
    transaction.replace(R.id.container, fr)
//    transaction.add(R.id.container, fr)
//        if (tag.length > 0) transaction.addToBackStack(tag)
//        transaction.addToBackStack(fr.toString())//bu kod stackka qoshadi
    transaction.commit()
}

fun FragmentActivity.replaceFragment(fr: Fragment) {
    val manager = this.supportFragmentManager
    val transaction = manager.beginTransaction()
    transaction.replace(R.id.container, fr)
    transaction.commit()
}

fun FragmentActivity.addFragment(fr: Fragment) {
    val manager = this.supportFragmentManager
    val transaction = manager.beginTransaction()
    transaction.replace(R.id.container, fr)
    transaction.addToBackStack(fr.toString())
    transaction.commit()
}