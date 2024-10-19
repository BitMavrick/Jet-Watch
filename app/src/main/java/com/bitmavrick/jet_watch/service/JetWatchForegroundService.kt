package com.bitmavrick.jet_watch.service

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Binder
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.NotificationCompat
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_CANCEL
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_START
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_STOP
import com.bitmavrick.jet_watch.util.Constants.STOPWATCH_STATE
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import javax.inject.Inject
import kotlin.time.Duration

@AndroidEntryPoint
class JetWatchForegroundService : Service(){

    @Inject
    lateinit var notificationManager: NotificationManager

    @Inject
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

    override fun onBind(intent: Intent?) = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.getStringExtra(STOPWATCH_STATE)){
            StopwatchState.Started.name -> {
                TODO()
            }

            StopwatchState.Stopped.name -> {
                TODO()
            }

            StopwatchState.Canceled.name -> {
                TODO()
            }
        }

        intent?.action.let {
            when (it){
                ACTION_SERVICE_START -> {
                    TODO()
                }

                ACTION_SERVICE_STOP -> {
                    TODO()
                }

                ACTION_SERVICE_CANCEL -> {
                    TODO()
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    inner class StopwatchBinder : Binder(){

        fun getService() : JetWatchForegroundService {
            return this@JetWatchForegroundService
        }
    }
}

enum class StopwatchState {
    Idle,
    Started,
    Stopped,
    Canceled
}