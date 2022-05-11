//package com.example.a15_puzzle
//
//import android.app.Dialog
//import android.content.Intent
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.opengl.Visibility
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuItem
//import android.view.View
//import android.view.Window
//import android.widget.ImageView
//import android.widget.RelativeLayout
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatDelegate
//import androidx.appcompat.widget.AppCompatButton
//import androidx.appcompat.widget.AppCompatImageView
//import androidx.appcompat.widget.SwitchCompat
//import com.example.a15_puzzle.utils.SharedPreferencesHelper
//import java.util.*
//import kotlin.collections.ArrayList
//import kotlin.concurrent.schedule
//import kotlin.math.absoluteValue
//
//class Main_Activity : AppCompatActivity() {
//    var allButtons = ArrayList<ArrayList<AppCompatButton>>()
//    var numbers = ArrayList<Int>()
//
//    val shared by lazy {
//        SharedPreferencesHelper(this)
//    }
//
//    var timeCounter = 0
//
//    lateinit var time: TextView
//    lateinit var passiveCoordinate: Coordinate
//    lateinit var btnParent: RelativeLayout
//    lateinit var restart: AppCompatButton
//    private val timer by lazy {
//        Timer()
//    }
//    private val dialog by lazy{
//        Dialog(this)
//    }
//    lateinit var userName : TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        restart = findViewById(R.id.startGame)
//
//        btnParent = findViewById(R.id.btnParent)
//        loadAllViews()
//        loadNumbers()
//            shuffle()
//        setTimer()
//
//        restart.setOnClickListener {
//            restart()
//        }
//    }
//
//
//    private fun restart() {
//        loadDataToView()
//        timer.cancel()
//        setTimer()
//    }
//
//    private fun loadAllViews() {
//        var list = ArrayList<AppCompatButton>()
//        for (i in 0 until btnParent.childCount) {
//            val b = btnParent.getChildAt(i)
//            b.setOnClickListener {
//                check(it as AppCompatButton)
//            }
//            b.tag = Coordinate(i / 4, i % 4)
//            list.add(b as AppCompatButton)
//            if ((i + 1) % 4 == 0) {
//                allButtons.add(list)
//                list = ArrayList()
//            }
//        }
//        /////
//
//        passiveCoordinate = Coordinate(shared.getX(), shared.getY())
//        //////
//        time = findViewById(R.id.time)
//    }
//
//    private fun loadNumbers() {
//        numbers.addAll(shared.getAllNumbers())
//    }
//
//    private fun loadDataToView() {
//        var t = 0
//        for (i in 0 until 4) {
//            for (j in 0 until 4) {
//                val t = numbers[t++]
//                if (t == -1) {
//                    allButtons[i][j].text = ""
////                    allButtons[i][j].setBackgroundResource(R.drawable.bg_passive_btn)
//                    allButtons[i][j].visibility = View.INVISIBLE
//                } else {
//                    allButtons[i][j].text = "$t"
//                    allButtons[i][j].setBackgroundResource(R.drawable.bg_active)
//                    allButtons[i][j].visibility = View.VISIBLE
//                }
//            }
//        }
//        timeCounter = shared.getTimerCount()
//        time.text = timeFormat(timeCounter)
//    }
//
//    fun shuffle() {
//        numbers.shuffle()
//    }
//
//    fun setTimer() {
//        timer.scheduleAtFixedRate(object : TimerTask() {
//            override fun run() {
//                runOnUiThread{
//                    time.text = timeFormat(++timeCounter)
//                }
//            }
//
//        }, 1000, 1000)
//    }
//
//    fun timeFormat(time: Int): String {
//        val minute = time / 60
//        val second = time % 60
//        val secondFormat = if (second < 10) "0${second}" else "$second"
//        val minuteFormat = if (minute < 10) "0${minute}" else "$minute"
//        return "${minuteFormat}:${secondFormat}"
//    }
//
//    private fun check(activeBtn: AppCompatButton) {
//        val activeCoordinate = activeBtn.tag as Coordinate
//        if (
//            (activeCoordinate.x - passiveCoordinate.x).absoluteValue
//            + (activeCoordinate.y - passiveCoordinate.y).absoluteValue == 1
//        ) {
//            val passiveBtn = allButtons[passiveCoordinate.x][passiveCoordinate.y]
//            passiveBtn.text = activeBtn.text
//            activeBtn.text = ""
//            passiveBtn.setBackgroundResource(R.drawable.bg_active)
//            passiveBtn.visibility = View.INVISIBLE
////            activeBtn.setBackgroundResource(R.drawable.bg_passive_btn)
//            activeBtn.visibility = View.VISIBLE
//
//            passiveCoordinate.x = activeCoordinate.x
//            passiveCoordinate.y = activeCoordinate.y
//
//            shared.setX(passiveCoordinate.x)
//            shared.setY(passiveCoordinate.y)
//            ////////////////////////////////////////
//
//            ///////////
//            if (isWin()) {
//                Toast.makeText(this, "You won ! ! !", Toast.LENGTH_SHORT).show()
//                timer.cancel()
//                Timer("SettingUp", false).schedule(2000) {
////                    val intent = Intent(this@ResumeGame, MainActivity2::class.java)
////                    intent.putExtras(bundle)
////                    startActivity(intent)
//                }
//            }
//        }
//    }
//
//    private fun isWin(): Boolean {
//        if (passiveCoordinate.x != 3 && passiveCoordinate.y != 3) return false
//        var isTrue = true
//        for (i in 0..14) {
//            isTrue = isTrue && "${i + 1}" == allButtons[(i) / 4][(i) % 4].text.toString()
//        }
//        return isTrue
//    }
//
//    override fun onStop() {
//        val numbers = ArrayList<Int>()
//        for (i in 0 until btnParent.childCount) {
//            val d = (btnParent.getChildAt(i) as AppCompatButton).text.toString()
//            if (d.isEmpty()) {
//                numbers.add(-1)
//            } else {
//                numbers.add(d.toInt())
//            }
//        }
//        shared.setX(passiveCoordinate.x)
//        shared.setY(passiveCoordinate.y)
//        shared.setAllNumbers(numbers)
//
//        shared.setTimerCount(timeCounter)
//        super.onStop()
//    }
//}