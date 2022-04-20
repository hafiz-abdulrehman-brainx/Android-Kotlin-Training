package com.example.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import java.lang.IllegalArgumentException

class ViewModelFactory(private var name:String):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) :T {
        if(modelClass.isAssignableFrom(MainViewModelFactory::class.java))
        {
            return MainViewModelFactory(name) as T
        }
        else{
            throw IllegalArgumentException("ViewModel class not found")
        }
    }
}