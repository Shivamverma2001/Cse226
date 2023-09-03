package com.example.sv_cse226

import android.R
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class BatteryLowBJSBL:BroadcastReceiver() {
    private val BATTERY_LEVEL = "level"
    override fun onReceive(p0: Context?, p1: Intent?) {
//        val level: Int = p1?.getIntExtra(BATTERY_LEVEL, 0) ?:
//        m
//        mBatteryLevelText.setText(getString(R.string.battery_level) + " " + level)
//        mBatteryLevelProgress.setProgress(level)
    }
}