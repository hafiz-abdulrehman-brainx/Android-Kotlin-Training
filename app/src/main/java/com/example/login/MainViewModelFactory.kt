package com.example.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModelFactory(name:String):ViewModel() {

    private var myName:String = name



    init{
        Log.d("MainViewModelFactory", ": My Channel Name is $myName ")

    }

}