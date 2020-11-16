package com.example.counttimesampleapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private var handler: Handler? = null
    var timerTv :TextView? =null
    var timerTv2 :TextView? =null
    /*set End Time for timer */
    private val endDateTime = "2019-03-21 10:15:00"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         timerTv = findViewById<TextView>(R.id.timerText)
         //timerTv2 = findViewById<TextView>(R.id.timerText2)
        startCountDown()
    }
    private var cTimer: CountDownTimer? = null

    private fun startCountDown() {
        val inputTimeInMilliSecs = Date().time + 40000
        val COUNT_DOWN_MS = 1240000L //inoutTimeinM Date().time
        cTimer = object : CountDownTimer(COUNT_DOWN_MS, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var diff = millisUntilFinished
                val secondsInMilli: Long = 1000
                val minutesInMilli = secondsInMilli * 60
                val hoursInMilli = minutesInMilli * 60
                val daysInMilli = hoursInMilli * 24

                val elapsedDays = diff / daysInMilli
                diff %= daysInMilli

                val elapsedHours = diff / hoursInMilli
                diff %= hoursInMilli

                val elapsedMinutes = diff / minutesInMilli
                diff %= minutesInMilli

                val elapsedSeconds = diff / secondsInMilli

                timerTv?.text = "$elapsedDays days $elapsedHours hs $elapsedMinutes min $elapsedSeconds sec"

                val sdf = SimpleDateFormat("dd hh:mm:ss")
                val netDate = Date(diff)
                val date =sdf.format(netDate)
               // timerTv2?.text = "$date"


            }

            override fun onFinish() {
            }
        }
        cTimer?.start()
    }

}