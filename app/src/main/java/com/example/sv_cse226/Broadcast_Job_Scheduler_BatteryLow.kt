package com.example.sv_cse226

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Broadcast_Job_Scheduler_BatteryLow : AppCompatActivity() {
    lateinit var mBatteryLevelText: TextView
    lateinit var mBatteryLevelProgress: ProgressBar
    lateinit var mReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_job_scheduler_battery_low)
        mBatteryLevelText = findViewById<TextView>(R.id.textView)
        mBatteryLevelProgress = findViewById<ProgressBar>(R.id.progressBar)

        mReceiver = BatteryBroadcastReceiver()
    }
    override fun onStart() {
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(mReceiver, intentFilter)
        super.onStart()
    }

    override fun onStop() {
        unregisterReceiver(mReceiver)
        super.onStop()
    }

    private inner class BatteryBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)

            mBatteryLevelText.text = "Battery Level: " + " $level"
            mBatteryLevelProgress.progress = level
            if(level<20){
                Toast.makeText(context,"Please charge your phone",Toast.LENGTH_LONG).show()
            }
        }
    }
}