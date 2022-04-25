package com.example.login.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.login.entities.School
import com.example.login.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolId",
        entityColumn = "schoolId"
    )
    val students: List<Student>
)
