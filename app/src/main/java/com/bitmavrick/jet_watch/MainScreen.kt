package com.bitmavrick.jet_watch

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bitmavrick.jet_watch.ui.theme.JetWatchTheme

@Composable
fun MainScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "00 : 00 : 00",
            style = MaterialTheme.typography.headlineLarge
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Start")
            }

            OutlinedButton(
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Reset")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen(){
    JetWatchTheme {
        MainScreen()
    }
}