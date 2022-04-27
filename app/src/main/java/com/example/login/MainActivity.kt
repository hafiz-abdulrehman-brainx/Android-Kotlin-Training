package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.databinding.ActivityMainListBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.adapter = UserListAdapter(getUserData())
        }

   private fun getUserData():List<User>{
       val userList = mutableListOf<User>()
       for (i in 1..20){
           userList.add(User("username $i", i))
       }
       return userList
   }
    data class User(
        val userName:String,
        val age:Int
    )
    }