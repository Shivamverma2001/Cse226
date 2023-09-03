package com.example.sv_cse226

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.util.Log
import android.widget.Toast

class JobServiceClass:JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("TAG","onStartJob")
        val i=Intent(this,BroadcastRecieverClass::class.java)
        val pI=PendingIntent.getBroadcast(this,234,i, PendingIntent.FLAG_IMMUTABLE)
        val alarmManager=getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pI)
        Toast.makeText(this,"Alarm Set",Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("TAG","onStopJob")
        return true
    }
}