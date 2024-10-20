package com.bitmavrick.jet_watch.root

import androidx.compose.runtime.Composable
import com.bitmavrick.jet_watch.service.JetWatchForegroundService
import com.bitmavrick.jet_watch.ui.home.HomeScreen

@Composable
fun JetWatch(
    stopwatchService : JetWatchForegroundService
) {
    HomeScreen( stopwatchService = stopwatchService )
}