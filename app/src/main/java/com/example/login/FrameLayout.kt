package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class FrameLayout : AppCompatActivity(), View.OnClickListener {
    lateinit var v1:ImageView
    lateinit var v2:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)
        v1 = findViewById<ImageView>(R.id.imageView4)
        v2 = findViewById<ImageView>(R.id.imageView5)
        v1.setOnClickListener(this)
        v2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.imageView4->  {
                Log.d("imageView", "onClick: imageView4 ")
                v1.isVisible = false
                v2.isVisible = true
            }
            R.id.imageView5->{
                Log.d("imageView", "onClick: imageView5")
                v1.isVisible = true
                v2.isVisible = false

            }
        }
    }
}