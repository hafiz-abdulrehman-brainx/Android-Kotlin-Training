package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.login.entities.*
import com.example.login.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var txtField :EditText
    lateinit var txtView : TextView
    lateinit var btnSearch :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dao = SchoolDatabase.getInstance(this).schoolDao

        txtField = findViewById<EditText>(R.id.txtfield)
        txtView = findViewById<TextView>(R.id.txtView)
        btnSearch = findViewById<Button>(R.id.searchBtn)

        val schools = listOf(
            School(0,"abdullah grammer"),
            School(0,"kotlin school"),
            School(0,"jetbrains school")
        )
        val subjects = listOf(
            Subject(0,"math"),
            Subject(0,"english"),
            Subject(0,"science")
        )
        val directors = listOf(
            Director(0,"hafiz",1),
            Director(0,"hamza",2),
            Director(0,"Dani",3)
        )
        val students = listOf(
            Student(0,"mohsin",1),
            Student(0,"ayesha",1),
            Student(0,"madeeha",1),
            Student(0,"abdullah",3),
            Student(0,"ahsan",3),
            Student(0,"haris",2),
            Student(0,"aziz",2)
        )
        val studentSubjectRelations= listOf(
            StudentSubjectCrossRef(1,2),
            StudentSubjectCrossRef(1,2),
            StudentSubjectCrossRef(2,1),
            StudentSubjectCrossRef(3,1),
            StudentSubjectCrossRef(4,2),
            StudentSubjectCrossRef(5,3),
            StudentSubjectCrossRef(6,2),
            StudentSubjectCrossRef(7,3),
        )
        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it)}
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }
            Log.d("Database1", "onCreate: Inserted")


        }
        btnSearch.setOnClickListener {
            searchStudentWithId(it)
        }

    }

    fun searchStudentWithId(view: View) {

        var dao = SchoolDatabase.getInstance(this).schoolDao
        var studentId = txtField.text.toString().toInt()
        lifecycleScope.launch {
            val student = dao.getSubjectsOfStudent(studentId).first()
            withContext(Dispatchers.Main){
                txtView.text = student.student.studentName
            }
        }
    }


}