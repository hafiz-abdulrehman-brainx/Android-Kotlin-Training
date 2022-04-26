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

class UpdateStudent : AppCompatActivity() {
    lateinit var btnStuUpdate: Button
    lateinit var txtStuName : EditText
    lateinit var txtStuId: EditText
    lateinit var dao : SchoolDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_student)

        btnStuUpdate = findViewById(R.id.btnStuUpdate)
        txtStuName = findViewById(R.id.txtStuName)
        txtStuId = findViewById(R.id.txtStuId)

        dao = SchoolDatabase.getInstance(this).schoolDao
        btnStuUpdate.setOnClickListener {
            updateStudent(it)
        }
    }

    private fun updateStudent(view: View) {
        val student= Student(txtStuId.text.toString().toInt(),txtStuName.text.toString(),0)
        lifecycleScope.launch {
            if(isActive){
                dao.insertStudent(student)
                Toast.makeText(this@UpdateStudent,"student : "+ txtStuName.text.toString() + " updated" ,
                    Toast.LENGTH_SHORT).show()
            }
        }
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}