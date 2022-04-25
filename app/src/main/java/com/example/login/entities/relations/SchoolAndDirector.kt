package com.example.login.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.login.entities.Director
import com.example.login.entities.School


data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
      parentColumn = "schoolId",
      entityColumn = "schoolId"
    )
    val director:Director


)
