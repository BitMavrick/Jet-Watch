package com.bitmavrick.jet_watch.ui.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bitmavrick.jet_watch.service.StopwatchState
import com.bitmavrick.jet_watch.ui.theme.JetWatchTheme

@Composable
fun HomeScreen(
    hours : String,
    minutes : String,
    seconds : String,
    currentState : StopwatchState
){
    Scaffold(
        content = { innerPadding ->
            HomeContent(
                innerPadding,
                hours,
                minutes,
                seconds,
                currentState
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    JetWatchTheme {
        HomeScreen(
            hours = "00",
            minutes = "00",
            seconds = "00",
            StopwatchState.Idle
        )
    }
}