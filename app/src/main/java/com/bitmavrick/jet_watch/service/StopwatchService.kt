package com.bitmavrick.jet_watch.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class StopwatchService : Service(){
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

}

enum class StopwatchState {
    Idle,
    Started,
    Stopped,
    Canceled
}