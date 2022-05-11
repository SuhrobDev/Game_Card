package com.example.memorygame.model

import com.example.memorygame.R
import com.example.memorygame.model.Model

class ImageList {
    private val list = ArrayList<ArrayList<Model>>()
    fun getAllImage(i: Int): ArrayList<Model> {
        val m1 = ArrayList<Model>()
        m1.add(Model(R.drawable.animals_1))
        m1.add(Model(R.drawable.animals_2))
        m1.add(Model(R.drawable.animals_3))
        m1.add(Model(R.drawable.animals_4))
        m1.add(Model(R.drawable.animals_5))
        m1.add(Model(R.drawable.animals_6))
        m1.add(Model(R.drawable.animals_7))
        m1.add(Model(R.drawable.animals_8))
        m1.add(Model(R.drawable.animals_1))
        m1.add(Model(R.drawable.animals_2))
        m1.add(Model(R.drawable.animals_3))
        m1.add(Model(R.drawable.animals_4))
        m1.add(Model(R.drawable.animals_5))
        m1.add(Model(R.drawable.animals_6))
        m1.add(Model(R.drawable.animals_7))
        m1.add(Model(R.drawable.animals_8))
        list.addAll(listOf(m1))

        val m2 = ArrayList<Model>()
        m2.add(Model(R.drawable.animals_9))
        m2.add(Model(R.drawable.animals_10))
        m2.add(Model(R.drawable.animals_11))
        m2.add(Model(R.drawable.animals_12))
        m2.add(Model(R.drawable.animals_13))
        m2.add(Model(R.drawable.animals_14))
        m2.add(Model(R.drawable.animals_15))
        m2.add(Model(R.drawable.animals_16))
        m2.add(Model(R.drawable.animals_14))
        m2.add(Model(R.drawable.animals_15))
        m2.add(Model(R.drawable.animals_11))
        m2.add(Model(R.drawable.animals_13))
        m2.add(Model(R.drawable.animals_16))
        m2.add(Model(R.drawable.animals_12))
        m2.add(Model(R.drawable.animals_10))
        m2.add(Model(R.drawable.animals_9))
        list.addAll(listOf(m2))

        val m3 = ArrayList<Model>()
        m3.add(Model(R.drawable.animals_17))
        m3.add(Model(R.drawable.animals_18))
        m3.add(Model(R.drawable.animals_19))
        m3.add(Model(R.drawable.animals_20))
        m3.add(Model(R.drawable.animals_21))
        m3.add(Model(R.drawable.animals_22))
        m3.add(Model(R.drawable.animals_23))
        m3.add(Model(R.drawable.animals_24))
        m3.add(Model(R.drawable.animals_17))
        m3.add(Model(R.drawable.animals_18))
        m3.add(Model(R.drawable.animals_19))
        m3.add(Model(R.drawable.animals_20))
        m3.add(Model(R.drawable.animals_21))
        m3.add(Model(R.drawable.animals_22))
        m3.add(Model(R.drawable.animals_23))
        m3.add(Model(R.drawable.animals_24))
        list.addAll(listOf(m3))

        return list[i]
    }
}