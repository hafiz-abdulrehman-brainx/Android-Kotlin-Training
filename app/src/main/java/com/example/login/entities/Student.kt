package com.example.login.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentId:Int,
    val studentName:String,
    val schoolId:Int
)
