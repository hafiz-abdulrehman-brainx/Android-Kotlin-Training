package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun logOut(view: View){
        val intentLogout = Intent(this, MainActivity::class.java)
        startActivity(intentLogout)
    }


}