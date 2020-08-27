package com.demo.androiddemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
/**
* welcome page
* @author FrankWang
* @time 2020/8/27 10:59 AM
*/
class SplashActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        makeFullScreen()

        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            startActivity(Intent(this,MainActivity::class.java))

            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

            finish()

        },3000)
    }

    private fun makeFullScreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
    }
}