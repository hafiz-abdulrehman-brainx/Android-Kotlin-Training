package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModelF = ViewModelFactory("Abdulrehman")
        var viewmodel = ViewModelProvider(this,viewModelF).get(MainViewModelFactory::class.java)

    }


}