package com.example.memorygame.ui


import android.animation.Animator
import com.example.memorygame.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreated() {
        binding.img.alpha=0.0f
        binding.img.animate()
            .alpha(1.0f)
            .setDuration(3000)
            .setListener(object : Animator.AnimatorListener{
                override fun onAnimationStart(p0: Animator?) {

                }

                override fun onAnimationEnd(p0: Animator?) {
                    replaceFragment(MenuFragment())
                }

                override fun onAnimationCancel(p0: Animator?) {

                }

                override fun onAnimationRepeat(p0: Animator?) {

                }

            })
    }

}