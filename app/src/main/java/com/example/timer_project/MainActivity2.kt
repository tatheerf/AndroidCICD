package com.example.timer_project

import android.R
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.timer_project.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
                val mimeType = "text/html"
                val encoding = "UTF-8"
                val html =
                    "<br /><br />Read the handouts please for tomorrow.<br /><br /><!--homework help homework" +
                            "help help with homework homework assignments elementary school high school middle school" +
                            "// --><font color='#60c000' size='4'><strong>Please!</strong></font>" +
                            "<img src='http://www.homeworknow.com/hwnow/upload/images/tn_star300.gif'  />"
                binding.webView.loadDataWithBaseURL("", html, mimeType, encoding, "")
            }
        }