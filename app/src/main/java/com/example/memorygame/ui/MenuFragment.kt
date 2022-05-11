package com.example.memorygame.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.memorygame.R
import com.example.memorygame.databinding.FragmentMenuBinding


class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {
    override fun onViewCreated() {
        val anim = AnimationUtils.loadAnimation(requireContext(),R.anim.move_left)
        binding.play.startAnimation(anim)
        binding.score.startAnimation(anim)
        binding.settings.startAnimation(anim)
        binding.tvplay.startAnimation(anim)
        binding.tvscore.startAnimation(anim)
        binding.tvset.startAnimation(anim)
        binding.play.setOnClickListener {
            replaceFragment(PlayFragment())
        }
        binding.settings.setOnClickListener {

        }
    }


}