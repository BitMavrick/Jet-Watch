package com.bitmavrick.jet_watch.ui.permission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun InitialPermissionScreen(
    onClickGranted : () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Jet Watch need notification permission to work properly")

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                onClickGranted()
            }
        ) {
            Text("Grand Access")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InitialPermissionScreenPreview(){
    InitialPermissionScreen(
        onClickGranted = {}
    )
}