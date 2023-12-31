package com.example.sv_cse226

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeBJSD:BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val isAirplaneModeEnabled=p1?.getBooleanExtra("state",false)?:return
        if(isAirplaneModeEnabled){
            Toast.makeText(p0,"AirplaneMode Enabled",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(p0,"AirplaneMode Disabled",Toast.LENGTH_LONG).show()
        }
    }
}