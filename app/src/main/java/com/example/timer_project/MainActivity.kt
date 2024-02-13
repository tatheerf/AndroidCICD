package com.example.timer_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.timer_project.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var elapsedTime: Long = 100
    private var countDownTimer: CountDownTimer? = null
    var isPaused:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
//        val duration = 100000L // 100 seconds in milliseconds
        countDownTimer=object : CountDownTimer(Long.MAX_VALUE, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                if(!isPaused) {
                    elapsedTime += 1L
                    val seconds = (elapsedTime % 60).toInt()
                    val minutes = (elapsedTime / 60).toInt()
                    val hours = (elapsedTime / 3600).toInt()
                    val timeString =
                        String.format("%02d:%02d:%02d", hours, minutes % 60, seconds % 60)
                    binding.tvTimer.text = timeString
                }
            }
            override fun onFinish() {
//                binding.tvTimer.text  = "00:00:00"
            }
        }.start()


    }

    private fun clickListener() {
        binding.btnPause.setOnClickListener {
            if (isPaused) {
                binding.btnPause.text = "Pause"
                isPaused = false
            } else {
                binding.btnPause.text = "Resume"
                isPaused = true
            }
        }
        binding.btnStop.setOnClickListener {
            countDownTimer?.cancel()
            binding.tvTimer.text  = "00:00:00"
        }
    }
}