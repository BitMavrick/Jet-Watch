package com.bitmavrick.jet_watch.service

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.NotificationCompat
import com.bitmavrick.jet_watch.util.pad
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import kotlin.concurrent.fixedRateTimer
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds


@AndroidEntryPoint
class StopwatchService : Service(){

    lateinit var notificationManager: NotificationManager

    lateinit var notificationBuilder: NotificationCompat.Builder

    private val binder = StopwatchBinder()

    private var duration: Duration = Duration.ZERO

    private lateinit var timer: Timer

    var seconds = mutableStateOf("00")
        private set

    var minutes = mutableStateOf("00")
        private set

    var hours = mutableStateOf("00")
        private set

    var currentState = mutableStateOf(StopwatchState.Idle)
        private set



    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun startStopWatch(onTick: (h: String, m: String, s: String) -> Unit) {
        currentState.value = StopwatchState.Started

        timer = fixedRateTimer(initialDelay = 1000L, period = 1000L){
            duration = duration.plus(1.seconds)
            updateTimeUnits()
            onTick(hours.value, minutes.value, seconds.value)
        }
    }

    private fun updateTimeUnits() {
        duration.toComponents { hours, minutes, seconds, _ ->
            this@StopwatchService.hours.value = hours.toInt().pad()
            this@StopwatchService.minutes.value = minutes.pad()
            this@StopwatchService.seconds.value = seconds.pad()
        }
    }

    inner class StopwatchBinder : Binder(){
        fun getService() : StopwatchService = this@StopwatchService
    }
}

enum class StopwatchState {
    Idle,
    Started,
    Stopped,
    Canceled
}