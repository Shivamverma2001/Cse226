package com.example.sv_cse226

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class BroadcastRecieverClass:BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        var mp=MediaPlayer.create(context,R.raw.alarm)
        Log.d("Hello","repeating alarm")
        mp.start()
        Toast.makeText(context,"Message",Toast.LENGTH_SHORT).show()
    }
}