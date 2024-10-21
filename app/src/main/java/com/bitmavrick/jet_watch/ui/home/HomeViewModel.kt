package com.bitmavrick.jet_watch.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.bitmavrick.jet_watch.service.ServiceHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    fun start(context: Context) {
        ServiceHelper.triggerForegroundService(context, "Start")
    }
}
