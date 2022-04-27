package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.databinding.UserItemBinding

class UserListAdapter(private val userList :List<MainActivity.User>) :RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    inner class UserViewHolder(val itemBinding: UserItemBinding) : RecyclerView.ViewHolder(itemBinding.root) // changed itemView to binding and passed binding.root
// no need to use findViewById now
//        val tvUserName = itemView.findViewById<TextView>(R.id.tv_userItem1)
//        val userAge = itemView.findViewById<TextView>(R.id.tv_age)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.UserViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
//        val view = layoutInflator.inflate(R.layout.user_item,parent,false) // dont need it
        val binding = UserItemBinding.inflate(layoutInflator,parent,false)
        return UserViewHolder(binding)
    }
    override fun onBindViewHolder(holder: UserListAdapter.UserViewHolder, position: Int) {
        val user = userList[position]
        holder.itemBinding.apply {
            tvUserItem1.text = user.userName
            tvAge.text = user.age.toString()
        }

// dont need to use these
//        holder.tvUserName.text = user.userName
//        holder.userAge.text = user.age.toString()
    }
    override fun getItemCount(): Int =userList.size


}