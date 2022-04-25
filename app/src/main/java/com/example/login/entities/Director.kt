package com.example.login.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(autoGenerate = true)
    val directorId:Int,
    val directorName:String,
    val schoolId:Int
)
