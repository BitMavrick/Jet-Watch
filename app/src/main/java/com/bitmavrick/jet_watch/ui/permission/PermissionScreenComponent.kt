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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MainPermissionScreen(
    onClickGranted : () -> Unit,
    onClickAppSettings : () -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jet Watch need notification permission \n to work properly",
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                onClickGranted()
            }
        ) {
            Text("Grand Access")
        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = "If you can't see the permission prompt, then open the settings and give permission manually*",
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                onClickAppSettings()
            }
        ) {
            Text("Open App Settings")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPermissionScreenPreview(){
    MainPermissionScreen(
        onClickGranted = {}
    )
}