package com.bitmavrick.jet_watch.ui.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.bitmavrick.jet_watch.service.JetWatchForegroundService

@Composable
fun HomeScreen(
    stopwatchService : JetWatchForegroundService
){
    Scaffold(
        content = { innerPadding ->
            HomeContent(innerPadding)
        }
    )
}