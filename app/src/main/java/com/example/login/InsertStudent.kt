package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.login.entities.SchoolDao
import com.example.login.entities.Student
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class InsertStudent : AppCompatActivity() {
    lateinit var btnAddStu:Button
    lateinit var txtStuName :  EditText
    lateinit var txtSchId: EditText
    lateinit var dao : SchoolDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_student)
        btnAddStu = findViewById(R.id.btnStuAdd)
        txtStuName = findViewById(R.id.txtStuName)
        txtSchId = findViewById(R.id.txtSchId)

        dao = SchoolDatabase.getInstance(this).schoolDao

        btnAddStu.setOnClickListener {
            insertStudent(it)
        }
    }
    fun insertStudent(view: View){
        val student=Student(0,txtStuName.text.toString(),txtSchId.text.toString().toInt())

        lifecycleScope.launch {
            if(isActive){
                dao.insertStudent(student)
                Toast.makeText(this@InsertStudent,"student : "+ txtStuName.text.toString() + " added" ,Toast.LENGTH_SHORT).show()
            }

        }
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}