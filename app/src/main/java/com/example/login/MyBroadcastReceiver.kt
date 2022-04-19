package com.example.login

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context,intent: Intent?) {
        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if(isAirPlaneModeEnabled){
            Toast.makeText(context, "Airplane mode enabled", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Airplane mode disabled", Toast.LENGTH_SHORT).show()
        }
    }
}