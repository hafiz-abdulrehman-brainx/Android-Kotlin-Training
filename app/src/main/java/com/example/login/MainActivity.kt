package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todolist = mutableListOf(
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false),
            Todo("Do this",false)
         )
        val adapter = TodoAdapter(todolist)
        recycle.adapter = adapter
        recycle.layoutManager = LinearLayoutManager(this)


        btnAdd.setOnClickListener {
            val title = txt.text.toString()
            val todo = Todo(title, false)
            todolist.add(todo)
            adapter.notifyItemChanged(todolist.size-1)
        }
    }

}