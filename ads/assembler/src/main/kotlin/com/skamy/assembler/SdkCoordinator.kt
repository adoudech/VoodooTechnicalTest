package com.skamy.assembler

import com.skamy.api.AdDisplayer
import com.skamy.api.AdInitializer
import com.skamy.api.AdLoader
import com.skamy.api.AdsObserver
import com.skamy.api.AdsState
import com.skamy.data.dataModule
import com.skamy.domain.domainModule
import com.skamy.domain.loadad.Ad
import com.skamy.domain.loadad.LoadAdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.context.GlobalContext.startKoin

class SdkCoordinator(
    private val loadAdUseCase: LoadAdUseCase,
) : AdInitializer, AdLoader, AdDisplayer, AdsObserver {

    override val state: MutableStateFlow<AdsState> = MutableStateFlow(AdsState.Idle)

    private var loadedAd: Ad? = null

    override fun initialize(uuid: String) {
        initialize()
    }

    private fun initialize() {
        startKoin {
            modules(
                listOf(
                    domainModule,
                    dataModule,
                )
            )
        }
    }

    override suspend fun loadAd() {
        loadAdUseCase.invoke().onSuccess {
            loadedAd = it
            state.tryEmit(AdsState.Loaded)
        }.onFailure {
            println("Error loading ad")
            state.tryEmit(AdsState.FailToLoad)
        }
    }

    override fun displayAd() {
        state.tryEmit(AdsState.Shown)
    }
}
