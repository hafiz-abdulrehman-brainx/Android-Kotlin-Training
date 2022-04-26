package com.example.login.entities

import androidx.room.*
import com.example.login.entities.relations.*

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Update()
    suspend fun updateSchool(school:School)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // convenience annotation
    suspend fun insertDirector(director: Director)

    @Update
    suspend fun updateDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // convenience annotation
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // convenience annotation
    suspend fun insertSubject (subject: Subject)

    @Update
    suspend fun updateSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // convenience annotation
    suspend fun insertStudentSubjectCrossRef (crossRef: StudentSubjectCrossRef)

    @Update
    suspend fun updateStudentSubjectCrossRef(school:School,subject: Subject)


    @Transaction // to make it thread-safe
    @Query("SELECT * FROM school WHERE schoolId= :schoolId") // query annotation
    suspend fun getSchoolAndDirectorWithSchoolId(schoolId:Int):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolId= :schoolId")
    suspend fun getSchoolWithStudents(schoolId: Int):List<SchoolWithStudents>

    @Transaction // to make it thread-safe
    @Query("SELECT * FROM subject WHERE subjectId= :subjectId") // query annotation
    suspend fun getStudentsOfSubject(subjectId:Int):List<SubjectWithStudents>

    @Transaction // to make it thread-safe
    @Query("SELECT * FROM student WHERE studentId= :studentId") // query annotation
    suspend fun getSubjectsOfStudent(studentId:Int):List<StudentWithSubjects>

    @Query("DELETE FROM student")
    suspend fun deleteStudentTable()

    @Query("DELETE FROM subject")
    suspend fun deleteSubjectTable()

    @Query("DELETE FROM director")
    suspend fun deleteDirectorTable()

    @Query("DELETE FROM school")
    suspend fun deleteSchoolTable()

    @Query("DELETE FROM studentsubjectcrossref")
    suspend fun deleteStudentSubjectCrossRefTable()


}