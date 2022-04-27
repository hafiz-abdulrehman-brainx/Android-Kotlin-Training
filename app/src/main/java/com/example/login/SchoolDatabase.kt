package com.example.login

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.login.entities.*
import com.example.login.entities.relations.StudentSubjectCrossRef

@Database(entities = [
    School::class,
    Student::class,
    Director::class,
    Subject::class,
    StudentSubjectCrossRef::class], version = 2)
abstract class SchoolDatabase:RoomDatabase() {
    abstract val schoolDao:SchoolDao

    companion object{
        @Volatile
        private var INSTANCE :SchoolDatabase?=null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).fallbackToDestructiveMigration()
                    .build().also {
                    INSTANCE = it
                }

                }
             }

        }
    }