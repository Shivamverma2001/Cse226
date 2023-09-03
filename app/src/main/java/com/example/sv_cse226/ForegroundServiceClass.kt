package com.example.sv_cse226

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundServiceClass: Service() {
    val CHANNEL_ID="Foreground Service using Kotlin"
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val i=intent?.getStringExtra("inputExtra")
        createNotificationChannel()
        val notificationIntent=Intent(this,ForegroundServiceDemo::class.java)
        val pendingIntent=PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_IMMUTABLE)
        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Foreground Service using Kotlin")
            .setContentText(i)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1,notification)
        return START_NOT_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
    }
    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val serviceChannel=NotificationChannel(CHANNEL_ID,"Foreground Service Channel",NotificationManager.IMPORTANCE_DEFAULT)
            val manager=getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }
}