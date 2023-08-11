package com.example.emmar_assignment.ui.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.emmar_assignment.R

/**
 * Created by Dhanmeet on 11/08/23.
 */
class SplashScreenActivity : AppCompatActivity() {

    // 3 seconds timeout for splash screen
    private val timeOut: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        initView()
    }

    private fun initView() {
        Handler().postDelayed({
            val mainIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            this@SplashScreenActivity.startActivity(mainIntent)
            this@SplashScreenActivity.finish()
        }, timeOut)
    }
}