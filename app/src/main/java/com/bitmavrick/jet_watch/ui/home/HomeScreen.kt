package com.bitmavrick.jet_watch.ui.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(){
    Scaffold(
        content = { innerPadding ->
            HomeContent(innerPadding)
        }
    )
}