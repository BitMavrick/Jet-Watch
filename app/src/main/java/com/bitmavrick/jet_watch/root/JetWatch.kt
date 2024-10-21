package com.bitmavrick.jet_watch.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bitmavrick.jet_watch.service.JetWatchForegroundService
import com.bitmavrick.jet_watch.ui.home.HomeScreen
import com.bitmavrick.jet_watch.ui.home.HomeViewModel

@Composable
fun JetWatch(
    stopwatchService : JetWatchForegroundService,
    homeViewModel: HomeViewModel = viewModel()
) {
    val hours by stopwatchService.hours
    val minutes by stopwatchService.minutes
    val seconds by stopwatchService.seconds
    val currentState by stopwatchService.currentState

    HomeScreen(
        hours = hours,
        minutes = minutes,
        seconds = seconds,
        currentState = currentState,
        homeOnEvent = homeViewModel::onEvent
    )
}