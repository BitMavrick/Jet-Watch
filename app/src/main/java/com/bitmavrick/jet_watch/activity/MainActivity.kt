package com.bitmavrick.jet_watch.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import com.bitmavrick.jet_watch.ui.theme.JetWatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetWatchTheme {
                // * Code From Here

                Text("Hello World")
            }
        }
    }
}