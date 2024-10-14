package com.bitmavrick.jet_watch.ui.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){
    Scaffold(
        content = { innerPadding ->
            HomeContent(innerPadding)
        }
    )
}


@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}