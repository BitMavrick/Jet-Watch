package com.bitmavrick.jet_watch.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.bitmavrick.jet_watch.service.ServiceHelper
import com.bitmavrick.jet_watch.service.StopwatchState
import com.bitmavrick.jet_watch.ui.theme.JetWatchTheme
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_CANCEL
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_START
import com.bitmavrick.jet_watch.util.Constants.ACTION_SERVICE_STOP

@Composable
fun HomeContent(
    paddingValues: PaddingValues,
    hours : String,
    minutes : String,
    seconds : String,
    currentState : StopwatchState
){
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface).padding(paddingValues),
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

@Preview(showBackground = true)
@Composable
fun HomeContentPreview(){
    JetWatchTheme {
        HomeContent(
            PaddingValues(),
            "00",
            "00",
            "00",
            StopwatchState.Idle
        )
    }
}