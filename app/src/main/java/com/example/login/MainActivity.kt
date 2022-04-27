package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.login.entities.*
import com.example.login.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Boolean.getBoolean

class MainActivity : AppCompatActivity() {

    lateinit var txtField :EditText
    lateinit var txtView : TextView
    lateinit var btnSearch :Button
    lateinit var dao:SchoolDao
    lateinit var btnStdInsert : Button
    lateinit var btnStdUpdate:Button
    lateinit var btnStdDelete:Button
    lateinit var btnSearchSubWithStu: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = SchoolDatabase.getInstance(this).schoolDao

        var sharedPref = getSharedPreferences("Database population", MODE_PRIVATE)
        var editor = sharedPref.edit()
        with(editor){
            if(!sharedPref.getBoolean("database empty",false)){
                putBoolean("database empty",true)
                apply()
                populateDatabase()
            }
            Toast.makeText(this@MainActivity,"Database populated",Toast.LENGTH_SHORT).show()
        }

        txtField = findViewById(R.id.txtfield)
        txtView = findViewById(R.id.txtView)
        btnSearch = findViewById(R.id.searchBtn)
        btnStdInsert = findViewById(R.id.btnStdInsert)
        btnStdUpdate = findViewById(R.id.btnStuUpdate)
        btnStdDelete = findViewById(R.id.btnStuDelete)
        btnSearchSubWithStu = findViewById(R.id.btnSearchSubjectWithStudent)


        btnSearch.setOnClickListener {
            searchStudentWithId(it)
        }
        btnStdInsert.setOnClickListener {
            var intent = Intent(this,InsertStudent::class.java)
            startActivity(intent)
        }
        btnStdUpdate.setOnClickListener {
            var intent = Intent(this,UpdateStudent::class.java)
            startActivity(intent)
        }
        btnStdDelete.setOnClickListener {
            deleteStudent(it)
        }
        btnSearchSubWithStu.setOnClickListener {
            searchStudentSubjects(it)
//            searchDirectorWithStuSubjects(it)
        }

    }

    private fun searchDirectorWithStuSubjects(view: View) {
        var studentId = txtField.text.toString().toInt()
        lifecycleScope.launch {
            var directors = dao.getAllDirectorsWithStudentsSubject(studentId)
            Log.d("Directors", directors.toString())
        }
    }

    private fun searchStudentSubjects(view: View) {
        var studentId = txtField.text.toString().toInt()
        lifecycleScope.launch{
            var subjects= dao.getSubjectsOfStudent(studentId).last()
            withContext(Dispatchers.Main){
                txtView.text = subjects.subjects.first().subjectName
            }
        }

    }

    private fun deleteStudent(view: View) {
        var studentId = txtField.text.toString().toInt()

        lifecycleScope.launch {
            dao.deleteStudentWithId(studentId)
        }
        Toast.makeText(this,"student with id: "+studentId + " deleted" ,Toast.LENGTH_SHORT).show()

    }


    private fun searchStudentWithId(view: View) {
        var studentId = txtField.text.toString().toInt()

        lifecycleScope.launch {
            val student = dao.getSubjectsOfStudent(studentId).first()
            withContext(Dispatchers.Main){
                txtView.text = student.student.studentName
            }
        }
    }
    fun populateDatabase(){

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
            Student(0,"abdullah",3),
            Student(0,"haris",2),
            Student(0,"aziz",2)
        )
        val studentSubjectRelations= listOf(
            StudentSubjectCrossRef(1,2),
            StudentSubjectCrossRef(1,3),
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
        }
    }


}