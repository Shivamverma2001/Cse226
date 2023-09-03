package com.example.sv_cse226

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class ForegroundServiceDemo : AppCompatActivity() {
    lateinit var start:Button
    lateinit var stop:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground_service_demo)
        start=findViewById(R.id.button1)
        stop=findViewById(R.id.button2)
        start.setOnClickListener{
            val i= Intent(this,ForegroundServiceClass::class.java)
            i.putExtra("inputExtra","Foreground Service using Kotlin")
            ContextCompat.startForegroundService(this,i)
        }
        stop.setOnClickListener {
            val i= Intent(this,ForegroundServiceClass::class.java)
            stopService(i)
        }
    }
}