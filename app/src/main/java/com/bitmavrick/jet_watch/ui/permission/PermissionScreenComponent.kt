package com.bitmavrick.jet_watch.ui.permission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bitmavrick.jet_watch.components.JetClockIcon


@Composable
fun MainPermissionScreen(
    onClickGranted : () -> Unit,
    onClickAppSettings : () -> Unit = {}
){
    Scaffold (
        topBar = {
            TopBar()
        },
        content = { innerPadding ->
            Body(innerPadding)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = ""
                    )
                },
                text = { Text("Grant Access") }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(){
    LargeTopAppBar(
        title = { Text("Welcome") }
    )
}

@Composable
private fun Body(
    padding: PaddingValues,
){
    Column (
        Modifier.fillMaxSize().padding(padding).padding(16.dp)
    ){
        Row(
            modifier = Modifier.height(200.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            JetClockIcon(
                contentDescription = null
            )
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