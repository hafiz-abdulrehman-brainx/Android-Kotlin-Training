package com.example.login.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val subjectId:Int,
    val subjectName:String
)
