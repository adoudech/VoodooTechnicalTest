package com.skamy.assembler

import com.skamy.api.AdsObserver
import com.skamy.api.AdsState

internal class Tracker(private val adsObserver: AdsObserver) {

    suspend fun track() {
        adsObserver.state.collect { adState ->
            when (adState) {
                is AdsState.Idle -> {
                    // Do nothing
                }

                is AdsState.Loaded -> {
                    // Track loaded
                }

                is AdsState.FailToLoad -> {
                    // Track fail to load
                }

                is AdsState.Disappear -> {
                    // Track disappear
                }

                is AdsState.Shown -> {
                    // Track shown
                }
            }
        }
    }
}
