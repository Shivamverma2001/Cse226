package com.example.sv_cse226

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.TextView

class BoundService : AppCompatActivity() {
    var mBoundService:BoundServiceClass?=null
    var mServiceBound=false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_service)
        val timestampText=findViewById<View>(R.id.textView) as TextView
        val start:Button=findViewById(R.id.start)
        val stop:Button=findViewById(R.id.stop)
        start.setOnClickListener {
            if(mServiceBound){
                timestampText.text=mBoundService!!.getTimestamp()
            }
        }
        stop.setOnClickListener {
            if(mServiceBound){
                unbindService(mServiceConnection)
                mServiceBound=false
            }
            val intent= Intent(this,BoundServiceClass::class.java)
            stopService(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val intent= Intent(this,BoundServiceClass::class.java)
        startService(intent)
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        if(mServiceBound){
            unbindService(mServiceConnection)
            mServiceBound=false
        }
    }
    val mServiceConnection:ServiceConnection=object :ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {
            mServiceBound=false
        }

        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            val myBinder:BoundServiceClass.MyBinder=service as BoundServiceClass.MyBinder
            mBoundService=myBinder.getService()
            mServiceBound=true
        }
    }
}