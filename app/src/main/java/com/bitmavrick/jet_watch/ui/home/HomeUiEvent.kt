package com.bitmavrick.jet_watch.ui.home

import android.content.Context

sealed interface HomeUiEvent {
    data class TriggerForegroundService(
        val context: Context,
        val status : String
    ) : HomeUiEvent
}