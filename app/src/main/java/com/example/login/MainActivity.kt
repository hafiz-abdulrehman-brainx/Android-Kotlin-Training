package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
        // type safe and null safe view objects associated with this activity
        txtOutput?.text = "new text with view binding" // make it nullable because it does not exist in landscape mode
        btnClick.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked",Toast.LENGTH_SHORT).show()
            val fragment = mainFragment()
             supportFragmentManager
                 .beginTransaction()
                 .add(R.id.frame_layout,fragment)
                 .commit()
        }
        }
    }

}