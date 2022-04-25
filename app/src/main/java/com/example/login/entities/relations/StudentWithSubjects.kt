package com.example.login.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.login.entities.Student
import com.example.login.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "subjectId",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects:List<Subject>
)
