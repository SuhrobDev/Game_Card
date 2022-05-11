//package com.example.memorygame.ui
//
//import android.animation.AnimatorInflater
//import android.animation.AnimatorSet
//import android.os.Bundle
//import android.os.CountDownTimer
//import android.os.Handler
//import android.os.Looper
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.RelativeLayout
//import android.widget.Toast
//import androidx.core.view.size
//import androidx.fragment.app.Fragment
//import com.example.memorygame.R
//import com.example.memorygame.databinding.FragmentPlayBinding
//import com.example.memorygame.model.ImageList
//import com.example.memorygame.model.Model
//import com.example.memorygame.utils.SharedPreferencesHelper
//import com.example.memorygame.utils.replaceFragment
//import java.util.*
//
//class PlayFragment : BaseFragment<FragmentPlayBinding>(FragmentPlayBinding::inflate) {
//    private lateinit var frontAnim : AnimatorSet
//    private lateinit var backAnim : AnimatorSet
//    private val timer by lazy {
//        Timer()
//    }
//    private val allVariationsViewGroup by lazy {
//        ArrayList<ViewGroup>()
//    }
//    private val bundle by lazy {
//        Bundle()
//    }
//    var timeCounter = 0
//    private val shared by lazy {
//        SharedPreferencesHelper(requireContext())
//    }
//    private lateinit var imageList : ArrayList<Model>
//    private var list = ImageList()
//    private var click = false
//
//    private val mHandler : Handler = Handler(Looper.getMainLooper())
////    private lateinit var binding : FragmentPlayBinding
//    var level = 0
//
//    override fun onViewCreat() {
////        super.onViewCreated(view , savedInstanceState)
//        level = shared.getLevel()
//        imageList = list.getAllImage(level)
//
//        loadView()
//        loadDataToView()
//        openImage()
//        setTimer()
//        binding.fontImageList.setOnClickListener {
//            if (!click) {
//                openImage()
//                click = true
//            }
//        }
//        binding.back.setOnClickListener {
//            requireActivity().replaceFragment(MenuFragment())
//        }
//    }
//
//    private var count = 0
//    private var pos = 0
//    private var score = 0
//    var isFront = false
//    var correctAnswer = 0
//
//
////    private fun check1() {
////        val list = binding.backImageList
////        val list2 = binding.fontImageList
////        var image1 : ImageView
////        var image2 : ImageView
////        var number1 = 0
////        var number2 = 0
////
////
////        var pos1 = 0
////        var pos2 = 0
////        val font = binding.fontImageList
////        val back = binding.backImageList
////        for (i in 0 until 16) {
////            list.getChildAt(i).setOnClickListener {
////                counter(it)
////                if (count != 2 && !imageList[i].isOpen) {
//////                    number1 = i
////                    ++count
////                    imageList[i].isOpen = true
////                    frontAnim = AnimatorInflater.loadAnimator(
////                        requireContext() ,
////                        R.animator.front_animator
////                    ) as AnimatorSet
////
////                    backAnim = AnimatorInflater.loadAnimator(
////                        requireContext() ,
////                        R.animator.back_animator
////                    ) as AnimatorSet
////
////                    val b = back.getChildAt(i)
////                    val f = font.getChildAt(i)
////
////                    frontAnim.setTarget(b)
////                    backAnim.setTarget(f)
////                    backAnim.start()
////                    frontAnim.start()
//////                    when (count) {
//////                        1 -> {
//////                            image1 = list2.getChildAt(i) as ImageView
//////                            number1 = i
////////                            Toast.makeText(requireContext() , "$number1" , Toast.LENGTH_SHORT)
////////                                .show()
//////                        }
//////                        2 -> {
//////                            image2 = list2.getChildAt(i) as ImageView
//////                            number2 = i
////////                            Toast.makeText(requireContext() , "$number2" , Toast.LENGTH_SHORT)
////////                                .show()
//////                            object : CountDownTimer(500 , 500) {
//////                                override fun onFinish() {
//////                                    count = 0
//////                                    if (number1 != number2) {
//////                                        if (imageList[number1].image == imageList[number2].image) {
//////                                            Toast.makeText(
//////                                                requireContext() ,
//////                                                "Correct!" ,
//////                                                Toast.LENGTH_SHORT
//////                                            ).show()
//////                                            Log.d("RRRRRR" , "$number1 = $number2")
//////                                        } else {
//////                                            for (j in 0 until 2) {
//////                                                frontAnim = AnimatorInflater.loadAnimator(
//////                                                    requireContext() ,
//////                                                    R.animator.front_animator
//////                                                ) as AnimatorSet
//////                                                backAnim = AnimatorInflater.loadAnimator(
//////                                                    requireContext() ,
//////                                                    R.animator.back_animator
//////                                                ) as AnimatorSet
//////                                                if (j == 0) {
//////                                                    frontAnim.setTarget(list2.getChildAt(number1))
//////                                                    backAnim.setTarget(list.getChildAt(number1))
//////                                                    frontAnim.start()
//////                                                    backAnim.start()
//////                                                } else if (j == 1) {
//////                                                    frontAnim.setTarget(list2.getChildAt(number2))
//////                                                    backAnim.setTarget(list.getChildAt(number2))
//////                                                    frontAnim.start()
//////                                                    backAnim.start()
//////                                                }
//////                                            }
//////                                        }
//////                                    }
//////                                }
//////
//////                                override fun onTick(millisUntilFinished : Long) {
//////
//////                                }
//////                            }.start()
//////
//////                        }
//////                    }
////
////                    if (count == 1) {
////                        pos1 = i
//////                        Toast.makeText(requireContext(), "$pos1", Toast.LENGTH_SHORT).show()
////                    } else if (count == 2) {
////                        pos2 = i
//////                        Toast.makeText(requireContext(), "$pos2", Toast.LENGTH_SHORT).show()
////                    }
////                } else if (count == 2) {
////                    count = 0
////                    if (imageList[pos1].image.hashCode() != imageList[pos2].image.hashCode() && imageList[pos1].isOpen && imageList[pos2].isOpen) {
////                        frontAnim = AnimatorInflater.loadAnimator(
////                            requireContext() ,
////                            R.animator.front_anim
////                        ) as AnimatorSet
////
////                        backAnim = AnimatorInflater.loadAnimator(
////                            requireContext() ,
////                            R.animator.back_anim
////                        ) as AnimatorSet
////
////                        val b1 = back.getChildAt(pos1)
////                        val b2 = back.getChildAt(pos2)
////                        val f1 = font.getChildAt(pos1)
////                        val f2 = font.getChildAt(pos2)
////
////                        frontAnim.setTarget(f1)
////                        backAnim.setTarget(b1)
////                        frontAnim.start()
////                        backAnim.start()
////
////                        frontAnim = AnimatorInflater.loadAnimator(
////                            requireContext() ,
////                            R.animator.front_anim
////                        ) as AnimatorSet
////
////                        backAnim = AnimatorInflater.loadAnimator(
////                            requireContext() ,
////                            R.animator.back_anim
////                        ) as AnimatorSet
////
////                        frontAnim.setTarget(f2)
////                        backAnim.setTarget(b2)
////                        frontAnim.start()
////                        backAnim.start()
////
////                        imageList[pos1].isOpen = false
////                        imageList[pos2].isOpen = false
////                    } else {
//////                            winFragment.arguments = bundleOf("TIME" to timeCounter)
////                        correctAnswer++
////                        if (correctAnswer == 8) {
////                            correctAnswer = 0
////                            level++
////                            shared.setTime(timeCounter)
////                            shared.setLevel(level)
////                            list.getAllImage(level)
////                            replaceFragment(WinFragment())
////                        }
////                    }
////                }
////            }
////        }
////    }
//
//    private fun check() {
//        var pos1 = 0
//        var pos2 = 0
//        val font = binding.fontImageList
//        val back = binding.backImageList
//        for (i in 0 until binding.backImageList.size) {
//            back.getChildAt(i).setOnClickListener {
//                if (click) {
//                    if (count != 2 && !imageList[i].isOpen) {
//                        ++count
//                        imageList[i].isOpen = true
//                        frontAnim = AnimatorInflater.loadAnimator(
//                            requireContext() ,
//                            R.animator.front_animator
//                        ) as AnimatorSet
//
//                        backAnim = AnimatorInflater.loadAnimator(
//                            requireContext() ,
//                            R.animator.back_animator
//                        ) as AnimatorSet
//
//                        val b = back.getChildAt(i)
//                        val f = font.getChildAt(i)
//
//                        frontAnim.setTarget(b)
//                        backAnim.setTarget(f)
//                        frontAnim.start()
//                        backAnim.start()
//                        if (count == 1) {
//                            pos1 = i
////                        Toast.makeText(requireContext(), "$pos1", Toast.LENGTH_SHORT).show()
//                        } else if (count == 2) {
//                            pos2 = i
////                        Toast.makeText(requireContext(), "$pos2", Toast.LENGTH_SHORT).show()
//                        }
//                    } else if (count == 2) {
//                        count = 0
//                        if (imageList[pos1].image.hashCode() != imageList[pos2].image.hashCode() && imageList[pos1].isOpen && imageList[pos2].isOpen) {
//                            frontAnim = AnimatorInflater.loadAnimator(
//                                requireContext() ,
//                                R.animator.front_animator
//                            ) as AnimatorSet
//
//                            backAnim = AnimatorInflater.loadAnimator(
//                                requireContext() ,
//                                R.animator.back_animator
//                            ) as AnimatorSet
//
//                            val b1 = back.getChildAt(pos1)
//                            val b2 = back.getChildAt(pos2)
//                            val f1 = font.getChildAt(pos1)
//                            val f2 = font.getChildAt(pos2)
//
//                            frontAnim.setTarget(f1)
//                            backAnim.setTarget(b1)
//                            frontAnim.start()
//                            backAnim.start()
//
//                            frontAnim = AnimatorInflater.loadAnimator(
//                                requireContext() ,
//                                R.animator.front_animator
//                            ) as AnimatorSet
//
//                            backAnim = AnimatorInflater.loadAnimator(
//                                requireContext() ,
//                                R.animator.back_animator
//                            ) as AnimatorSet
//
//                            frontAnim.setTarget(f2)
//                            backAnim.setTarget(b2)
//                            frontAnim.start()
//                            backAnim.start()
//
//                            imageList[pos1].isOpen = false
//                            imageList[pos2].isOpen = false
//                        } else {
////                            winFragment.arguments = bundleOf("TIME" to timeCounter)
//                            correctAnswer++
//                            if (correctAnswer == 8) {
//                                correctAnswer = 0
//                                level++
//                                shared.setTime(timeCounter)
//                                shared.setLevel(level)
//                                list.getAllImage(level)
//                                replaceFragment(WinFragment())
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    override fun onViewCreated() {
//        TODO("Not yet implemented")
//    }
//}
//
//private fun loadView() {
//    for (i in 0 until binding.fontImageList.childCount) {
//        val clickedBtn = binding.backImageList.getChildAt(i)
//        clickedBtn.setOnClickListener {
//            check()
//        }
//        if (binding.fontImageList.getChildAt(i) is RelativeLayout) {
//            allVariationsViewGroup.add(binding.fontImageList.getChildAt(i) as RelativeLayout)
//        }
//    }
//}
//
//private fun loadDataToView() {
//    val d = list.getAllImage()
//    imageList = d[0]
//    for (i in 0 until binding.fontImageList.childCount) {
//        val image = binding.fontImageList.getChildAt(i) as ImageView
//        image.setImageResource(imageList[i].image)
//    }
//}
//
//private fun openImage() {
//    for (i in 0 until binding.fontImageList.childCount) {
////        val image = binding.fontImageList.getChildAt(i)
//
//        frontAnim = AnimatorInflater.loadAnimator(
//            requireContext() ,
//            R.animator.front_animator
//        ) as AnimatorSet
//
//        frontAnim.setTarget(image)
//        frontAnim.start()
//        closeImage()
//    }
//}
//
//private fun setTimer() {
//    timer.scheduleAtFixedRate(object : TimerTask() {
//        override fun run() {
//            mHandler.post {
//                binding.textTime.text = timeFormat((++timeCounter))
//            }
//        }
//
//    } , 1000 , 1000)
//}
//
//fun timeFormat(time : Int) : String {
//    val minute = time / 60
//    val second = time % 60
//    val secondFormat = if (second < 10) "0${second}" else "$second"
//    val minuteFormat = if (minute < 10) "0${minute}" else "$minute"
//    return "${minuteFormat}:${secondFormat}"
//}
//
//private fun closeImage() {
//    for (i in 0 until binding.backImageList.childCount) {
//        val image = binding.backImageList.getChildAt(i)
//
//        backAnim = AnimatorInflater.loadAnimator(
//            requireContext() ,
//            R.animator.back_animator
//        ) as AnimatorSet
//
//        backAnim.setTarget(image)
//        backAnim.start()
//    }
//}
//
//@Deprecated(
//    "Deprecated in Java" , ReplaceWith(
//        "super.setTargetFragment(fragment , requestCode)" ,
//        "androidx.fragment.app.Fragment"
//    )
//)
//override fun setTargetFragment(fragment : Fragment? , requestCode : Int) {
//    super.setTargetFragment(fragment , requestCode)
//}
//
//private fun startTimer() {
//    object : CountDownTimer(3000 , 1500) {
//        override fun onFinish() {
//            Toast.makeText(requireContext() , "fsadfsadf" , Toast.LENGTH_SHORT).show()
//        }
//
//        override fun onTick(millisUntilFinished : Long) {
//
//        }
//    }.start()
//}
//
//private fun counter(view : View) {
//    score++
//    binding.scoreCounter.text = score.toString()
//}
//}
package com.example.memorygame.ui

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.view.size
import com.example.memorygame.R
import com.example.memorygame.databinding.FragmentPlayBinding
import com.example.memorygame.models.ImageList
import com.example.memorygame.models.Model
//import com.example.memorygame.manager.GameManager
import com.example.memorygame.utils.SharedPreferencesHelper
import java.util.*
import kotlin.collections.ArrayList


class PlayFragment : BaseFragment<FragmentPlayBinding>(FragmentPlayBinding::inflate) {
    private lateinit var frontAnim : AnimatorSet
    private lateinit var backAnim : AnimatorSet
    private val timer by lazy {
        Timer()
    }
    private val bundle by lazy {
        Bundle()
    }
    private val allVariationsViewGroup by lazy {
        ArrayList<ViewGroup>()
    }
    private val shared by lazy {
        SharedPreferencesHelper(requireContext())
    }
    private val winFragment : WinFragment by lazy {
        WinFragment()
    }
    var timeCounter = 0

    var list = ImageList()
    lateinit var imageList : ArrayList<Model>
    private val mHandler : Handler = Handler(Looper.getMainLooper())
    var click = false
    var level = 0
    override fun onViewCreated() {
        level = shared.getLevel()
        imageList = list.getAllImage(level)

        loadView()
        loadDataToView()
        setTimer()
        Toast.makeText(requireContext() , "${shared.getLevel()}" , Toast.LENGTH_SHORT).show()
        binding.fontImageList.setOnClickListener {
            if (!click) {
                openImage()
                click = true
            }
        }

        binding.back.setOnClickListener {
            replaceFragment(MenuFragment())
        }
    }

    var correctAnswer = 0
    var count = 0

    private fun check() {
        var pos1 = 0
        var pos2 = 0
        val font = binding.fontImageList
        val back = binding.backImageList
        for (i in 0 until binding.backImageList.size) {
            back.getChildAt(i).setOnClickListener {
                if (click) {
                    if (count != 2 && !imageList[i].isOpen) {
                        ++count
                        imageList[i].isOpen = true
                        frontAnim = AnimatorInflater.loadAnimator(
                            requireContext() ,
                            R.animator.front_anim
                        ) as AnimatorSet

                        backAnim = AnimatorInflater.loadAnimator(
                            requireContext() ,
                            R.animator.back_anim
                        ) as AnimatorSet

                        val b = back.getChildAt(i)
                        val f = font.getChildAt(i)

                        frontAnim.setTarget(b)
                        backAnim.setTarget(f)
                        frontAnim.start()
                        backAnim.start()
                        if (count == 1) {
                            pos1 = i
//                        Toast.makeText(requireContext(), "$pos1", Toast.LENGTH_SHORT).show()
                        } else if (count == 2) {
                            pos2 = i
//                        Toast.makeText(requireContext(), "$pos2", Toast.LENGTH_SHORT).show()
                        }
                    } else if (count == 2) {
                        count = 0
                        if (imageList[pos1].image.hashCode() != imageList[pos2].image.hashCode() && imageList[pos1].isOpen && imageList[pos2].isOpen) {
                            frontAnim = AnimatorInflater.loadAnimator(
                                requireContext() ,
                                R.animator.front_anim
                            ) as AnimatorSet

                            backAnim = AnimatorInflater.loadAnimator(
                                requireContext() ,
                                R.animator.back_anim
                            ) as AnimatorSet

                            val b1 = back.getChildAt(pos1)
                            val b2 = back.getChildAt(pos2)
                            val f1 = font.getChildAt(pos1)
                            val f2 = font.getChildAt(pos2)

                            frontAnim.setTarget(f1)
                            backAnim.setTarget(b1)
                            frontAnim.start()
                            backAnim.start()

                            frontAnim = AnimatorInflater.loadAnimator(
                                requireContext() ,
                                R.animator.front_anim
                            ) as AnimatorSet

                            backAnim = AnimatorInflater.loadAnimator(
                                requireContext() ,
                                R.animator.back_anim
                            ) as AnimatorSet

                            frontAnim.setTarget(f2)
                            backAnim.setTarget(b2)
                            frontAnim.start()
                            backAnim.start()

                            imageList[pos1].isOpen = false
                            imageList[pos2].isOpen = false
                        } else {
//                            winFragment.arguments = bundleOf("TIME" to timeCounter)
                            correctAnswer++
                            if (correctAnswer == 8) {
                                correctAnswer = 0
                                level++
                                shared.setTime(timeCounter)
                                shared.setLevel(level)
                                list.getAllImage(level)
                                replaceFragment(WinFragment())
                            }
                        }
                    }
                }
            }
        }
    }

    private fun startTimer() {
        object : CountDownTimer(2000 , 100) {
            override fun onTick(p0 : Long) {
            }

            override fun onFinish() {
            }
        }
    }

    private fun loadView() {
        for (i in 0 until binding.fontImageList.childCount) {
            val clickedBtn = binding.backImageList.getChildAt(i)
            clickedBtn.setOnClickListener {
                check()
            }
            if (binding.fontImageList.getChildAt(i) is RelativeLayout) {
                allVariationsViewGroup.add(binding.fontImageList.getChildAt(i) as RelativeLayout)
            }
        }
    }


    private fun loadDataToView() {
//        imageList.shuffle()
        for (i in 0 until binding.fontImageList.childCount) {
            val image = binding.fontImageList.getChildAt(i) as ImageView
            image.setImageResource(imageList[i].image)
        }
    }

    private fun openImage() {
        for (i in 0 until binding.fontImageList.childCount) {

            frontAnim = AnimatorInflater.loadAnimator(
                requireContext() ,
                R.animator.front_anim
            ) as AnimatorSet

            val imageFont = binding.fontImageList.getChildAt(i)

            frontAnim.setTarget(imageFont)

            frontAnim.start()
            closeImage(i)
        }
    }

    private fun closeImage(i : Int) {
        val image = binding.backImageList.getChildAt(i)
        backAnim = AnimatorInflater.loadAnimator(
            requireContext() ,
            R.animator.back_anim
        ) as AnimatorSet
        backAnim.setTarget(image)
        backAnim.start()
    }

    private fun setTimer() {
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                mHandler.post {
                    shared.setTime(++timeCounter)
                    binding.textTime.text = timeFormat((shared.getTime()))
                }
            }
        } , 1000 , 1000)
    }

    fun timeFormat(time : Int) : String {
        val minute = time / 60
        val second = time % 60
        val secondFormat = if (second < 10) "0${second}" else "$second"
        val minuteFormat = if (minute < 10) "0${minute}" else "$minute"
        return "${minuteFormat}:${secondFormat}"
    }
}