package com.example.sv_cse226

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Broadcast_Job_Scheduler : AppCompatActivity() {
    var jobScheduler:JobScheduler?=null
    lateinit var start:Button
    lateinit var stop:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_job_scheduler)
        start=findViewById(R.id.b1)
        stop=findViewById(R.id.b2)
        start.setOnClickListener {
            jobScheduler=getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName=ComponentName(this,JobServiceClass::class.java)
            val builder=JobInfo.Builder(123,componentName)
            builder.setMinimumLatency(1000)
            builder.setOverrideDeadline(3000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())
        }
        stop.setOnClickListener {
            if(jobScheduler!=null){
                jobScheduler!!.cancel(123)
                jobScheduler=null
                Toast.makeText(this,"Job Cancelled",Toast.LENGTH_SHORT).show()
            }
        }
    }
}