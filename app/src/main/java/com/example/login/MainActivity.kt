package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun register(view:View){
        val intentSignup = Intent(this,SignUp::class.java)
        startActivity(intentSignup)
    }
    fun home(view: View){
        val intentHome = Intent(this,Home::class.java)
        startActivity(intentHome)
    }
}