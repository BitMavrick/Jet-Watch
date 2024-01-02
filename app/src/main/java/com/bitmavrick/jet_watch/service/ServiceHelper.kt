package com.bitmavrick.jet_watch.service

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.bitmavrick.jet_watch.MainActivity
import com.bitmavrick.jet_watch.util.Constants.CLICK_REQUEST_CODE
import com.bitmavrick.jet_watch.util.Constants.STOPWATCH_STATE

object ServiceHelper {

    private val flag = PendingIntent.FLAG_IMMUTABLE

    fun clickPendingIntent(context: Context) : PendingIntent {
        val clickIntent = Intent(context, MainActivity::class.java).apply {
            putExtra(STOPWATCH_STATE, StopwatchState.Started.name)
        }

        return PendingIntent.getActivity(
            context, CLICK_REQUEST_CODE, clickIntent, flag
        )

    }




}