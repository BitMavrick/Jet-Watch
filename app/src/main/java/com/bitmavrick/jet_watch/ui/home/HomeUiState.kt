package com.bitmavrick.jet_watch.ui.home

data class HomeUiState(
    val hours: String = "00",
    val minutes : String = "00",
    val seconds : String = "00",
    val currentState : StopwatchState = StopwatchState.Idle
)

enum class StopwatchState {
    Idle,
    Started,
    Stopped,
    Canceled
}
