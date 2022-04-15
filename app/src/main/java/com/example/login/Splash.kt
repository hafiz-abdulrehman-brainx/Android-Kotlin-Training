package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
//        Log.d("onCreate", "onCreate: is called ")
        Handler().postDelayed({
         val intentLogin = Intent(this, MainActivity::class.java)
            startActivity(intentLogin)
        },3000)
    }
}