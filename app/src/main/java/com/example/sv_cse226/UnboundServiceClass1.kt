package com.example.sv_cse226

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class UnboundServiceClass1: Service() {
    lateinit var mp:MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp= MediaPlayer.create(this@UnboundServiceClass1,Settings.System.DEFAULT_NOTIFICATION_URI)
        mp.setLooping(true)
        mp.start()
        return START_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        mp.stop()
//    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
        mp.stop()
    }
}