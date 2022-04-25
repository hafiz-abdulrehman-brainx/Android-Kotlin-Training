package com.example.login.entities

import androidx.room.*
import com.example.login.entities.relations.SchoolAndDirector
import com.example.login.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // convenience annotation
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // convenience annotation
    suspend fun insertStudent(student: Student)

    @Transaction // to make it thread-safe
    @Query("SELECT * FROM school WHERE schoolId= :schoolId") // query annotation
    suspend fun getSchoolAndDirectorWithSchoolId(schoolId:Int):List<SchoolAndDirector>


    @Transaction
    @Query("SELECT * FROM school WHERE schoolId= :schoolId")
    suspend fun getSchoolWithStudents(schoolId: Int):List<SchoolWithStudents>

}