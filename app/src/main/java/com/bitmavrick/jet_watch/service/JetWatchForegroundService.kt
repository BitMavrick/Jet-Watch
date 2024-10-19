package com.bitmavrick.jet_watch.service

import android.app.Service
import android.content.Intent
import android.os.Binder

class JetWatchForegroundService : Service(){

    private val binder = StopwatchBinder()


    override fun onBind(intent: Intent?) = binder

    inner class StopwatchBinder : Binder(){

        fun getService() : JetWatchForegroundService {
            return this@JetWatchForegroundService
        }
    }
}