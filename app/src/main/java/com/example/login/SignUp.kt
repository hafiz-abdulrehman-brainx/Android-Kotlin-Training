package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun signUp(view: View){
        val intentLogin = Intent(this, MainActivity::class.java)
        startActivity(intentLogin)
    }
}