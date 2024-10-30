package com.skamy.api

import kotlinx.coroutines.flow.StateFlow

sealed interface AdsState {
    data object Idle : AdsState
    data object Loaded : AdsState
    data object FailToLoad : AdsState
    data object Disappear : AdsState
    data object Shown : AdsState
}

interface AdsObserver {
    val state: StateFlow<AdsState>
}
