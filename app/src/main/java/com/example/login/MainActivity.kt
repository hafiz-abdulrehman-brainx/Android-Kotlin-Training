package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txt = findViewById<TextView>(R.id.txt)
        var btnStart = findViewById<Button>(R.id.btnStart)
        var btnStop = findViewById<Button>(R.id.btnStop)
        var number_input = findViewById<EditText>(R.id.number_input)
        var viewmodel = ViewModelProvider(this).get(MainActivityViewModelLiveData::class.java)



        viewmodel.seconds().observe(this, Observer{
            txt.text = it.toString()
        })
        viewmodel.finished.observe(this, Observer {
            if(it)
            Toast.makeText(this,"CountDown is finished",Toast.LENGTH_SHORT).show()
        })

        btnStart.setOnClickListener{
            if(number_input.text.isEmpty() || number_input.text.length<4)
            {
                Toast.makeText(this,"Invalid Number",Toast.LENGTH_SHORT).show()
            }
            else{
                viewmodel.timerValue.value = number_input.text.toString().toLong()
                number_input.text.clear()
                viewmodel.startTimer()
            }
            }
        btnStop.setOnClickListener {
            txt.text = "0"
            viewmodel.stopTimer()
        }
    }


}