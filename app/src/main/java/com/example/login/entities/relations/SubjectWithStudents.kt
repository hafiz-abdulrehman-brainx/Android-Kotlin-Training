package com.example.login.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.login.entities.Student
import com.example.login.entities.Subject


data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectId",
        entityColumn = "studentId",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students:List<Student>
)
