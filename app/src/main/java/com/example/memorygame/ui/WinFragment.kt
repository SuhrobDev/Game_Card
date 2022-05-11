package com.example.memorygame.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.memorygame.R
import com.example.memorygame.databinding.FragmentWinBinding
import com.example.memorygame.utils.SharedPreferencesHelper

class WinFragment : BaseFragment<FragmentWinBinding>(FragmentWinBinding::inflate) {
    private val bundle by lazy {
        this.arguments
    }

    private val shared by lazy{
        SharedPreferencesHelper(requireContext())
    }
    override fun onViewCreated() {
//        arguments?.let {
//            binding.time.text = timeFormat(it.getInt("TIME"))
//        }

        binding.time.text = timeFormat(shared.getTime())

        binding.home.setOnClickListener {
            replaceFragment(MenuFragment())
        }

        binding.next.setOnClickListener {
            replaceFragment(PlayFragment())
        }
    }

    private fun timeFormat(time: Int): String {
        val minute = time / 60
        val second = time % 60
        val secondFormat = if (second < 10) "0${second}" else "$second"
        val minuteFormat = if (minute < 10) "0${minute}" else "$minute"
        return "${minuteFormat}:${secondFormat}"
    }

}