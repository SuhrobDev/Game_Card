package com.example.memorygame.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.memorygame.R
import com.example.memorygame.controller.extention

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

    abstract class BaseFragment<VB : ViewBinding>(
        private val inflate: Inflate<VB>
    ) : Fragment() {
        private var _binding: VB? = null
        open val binding get() = _binding!!
        private val controller = extention.controller
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = inflate.invoke(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            onViewCreated()
        }

        abstract fun onViewCreated()

        fun replaceFragment(fragment: Fragment) {
            controller?.replaceFragment(fragment)
        }

        fun addFragment(fragment: Fragment){
            controller?.addFragment(fragment)
        }

        fun back(){
            controller?.back()
        }
        override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
            return if (enter) {
                AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in_right)
            } else {
                AnimationUtils.loadAnimation(requireContext(), R.anim.slide_out_left)
            }
        }
    }
