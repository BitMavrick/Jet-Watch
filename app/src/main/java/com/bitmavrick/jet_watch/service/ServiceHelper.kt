package com.bitmavrick.jet_watch.service

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.bitmavrick.jet_watch.activity.MainActivity
import com.bitmavrick.jet_watch.util.Constants.CANCEL_REQUEST_CODE
import com.bitmavrick.jet_watch.util.Constants.CLICK_REQUEST_CODE
import com.bitmavrick.jet_watch.util.Constants.RESUME_REQUEST_CODE
import com.bitmavrick.jet_watch.util.Constants.STOPWATCH_STATE
import com.bitmavrick.jet_watch.util.Constants.STOP_REQUEST_CODE

object ServiceHelper {
    private const val FLAG = PendingIntent.FLAG_IMMUTABLE

    fun clickPendingIntent(context: Context): PendingIntent {
        val clickIntent = Intent(context, MainActivity::class.java).apply {
            putExtra(STOPWATCH_STATE, StopwatchState.Started.name)
        }

        return PendingIntent.getActivity(
            context, CLICK_REQUEST_CODE, clickIntent, FLAG
        )
    }

    fun stopPendingIntent(context: Context): PendingIntent {
        val stopIntent = Intent(context, JetWatchForegroundService::class.java).apply {
            putExtra(STOPWATCH_STATE, StopwatchState.Stopped.name)
        }
        return PendingIntent.getService(
            context, STOP_REQUEST_CODE, stopIntent, FLAG
        )
    }

    fun resumePendingIntent(context: Context): PendingIntent {
        val resumeIntent = Intent(context, JetWatchForegroundService::class.java).apply {
            putExtra(STOPWATCH_STATE, StopwatchState.Started.name)
        }
        return PendingIntent.getService(
            context, RESUME_REQUEST_CODE, resumeIntent, FLAG
        )
    }

    fun cancelPendingIntent(context: Context): PendingIntent {
        val cancelIntent = Intent(context, JetWatchForegroundService::class.java).apply {
            putExtra(STOPWATCH_STATE, StopwatchState.Canceled.name)
        }
        return PendingIntent.getService(
            context, CANCEL_REQUEST_CODE, cancelIntent, FLAG
        )
    }

    fun triggerForegroundService(context: Context, action: String) {
        Intent(context, JetWatchForegroundService::class.java).apply {
            this.action = action
            context.startService(this)
        }
    }
}