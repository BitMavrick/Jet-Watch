package com.bitmavrick.jet_watch

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.bitmavrick.jet_watch.service.ServiceHelper
import com.bitmavrick.jet_watch.service.StopwatchService
import com.bitmavrick.jet_watch.service.StopwatchState
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_CANCEL
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_START
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_STOP

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(stopwatchService: StopwatchService){

    val context = LocalContext.current
    val hours by stopwatchService.hours
    val minutes by stopwatchService.minutes
    val seconds by stopwatchService.seconds

    val currentState by stopwatchService.currentState

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$hours : $minutes : $seconds",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = {
                    ServiceHelper.triggerForegroundService(
                        context = context,
                        action = if (currentState == StopwatchState.Started){
                                ACTION_SERVICE_STOP
                            }else{
                                ACTION_SERVICE_START
                            }
                    )
                }
            ) {
                if (currentState == StopwatchState.Started){
                    Text(text = "Resume")
                }else{
                    Text(text = "Start")
                }
            }

            OutlinedButton(
                onClick = {
                    ServiceHelper.triggerForegroundService(
                        context = context,
                        action = ACTION_SERVICE_CANCEL
                    )
                },
                enabled = seconds != "00" && currentState != StopwatchState.Started
            ) {
                Text(text = "Reset")
            }
        }
    }
}