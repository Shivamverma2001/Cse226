package com.example.sv_cse226

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast

class Broadcast_Job_Scheduler_Dynamic_wifi : AppCompatActivity() {
    lateinit var wifiSwitch:Switch
    lateinit var wifiManager: WifiManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_job_scheduler_dynamic_wifi)
        wifiSwitch=findViewById(R.id.switch1)
        wifiManager=applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                wifiManager.isWifiEnabled = true
                wifiSwitch.text = "Wifi is ON"
            } else {
                wifiManager.isWifiEnabled = false
                wifiSwitch.text = "Wifi is OFF"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val i=IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver,i)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }
    private val wifiStateReceiver:BroadcastReceiver=object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent) {
            when(p1.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN)){
                WifiManager.WIFI_STATE_ENABLED->{
                    wifiSwitch.isChecked=true
                    wifiSwitch.text="Wifi is On"
                    Toast.makeText(p0,"Wifi is ON",Toast.LENGTH_LONG).show()
                }
                WifiManager.WIFI_STATE_DISABLED->{
                    wifiSwitch.isChecked=false
                    wifiSwitch.text="Wifi is Off"
                    Toast.makeText(p0,"Wifi is OFF",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}