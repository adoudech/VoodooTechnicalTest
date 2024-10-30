package com.skamy.api

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object AdsFactory {

    fun createAdsObserver(): AdsObserver {
        return object : AdsObserver {
            override val state: StateFlow<AdsState> = MutableStateFlow(AdsState.Idle)
        }
    }

    fun createAdInitializer(): AdInitializer {
        return AdInitializer {
            // call the real implementation
        }
    }

    fun createAdLoader(): AdLoader {
        return AdLoader {
            // call the real implementation
        }
    }

    fun createAdDisplayer(): AdDisplayer {
        return AdDisplayer {
            // call the real implementation
        }
    }
}
