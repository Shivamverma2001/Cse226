package com.example.sv_cse226

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//Airplane Mode
class Broadcast_Job_Scheduler_Dynamic : AppCompatActivity() {
    lateinit var receiver:AirplaneModeBJSD
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_job_scheduler_dynamic)
        receiver= AirplaneModeBJSD()
        //dynamic broadcast receiver
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}