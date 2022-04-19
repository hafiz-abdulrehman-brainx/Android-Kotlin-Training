package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(),LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn = findViewById<Button>(R.id.btnApply)
        var txt = findViewById<TextView>(R.id.txt)
        var viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        txt.text=viewmodel.number.toString()
        btn.setOnClickListener{
            viewmodel.addNumber()
            txt.text=viewmodel.number.toString()
        }

    }


}