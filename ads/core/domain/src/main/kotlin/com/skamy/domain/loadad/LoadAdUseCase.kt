package com.skamy.domain.loadad

class LoadAdUseCase internal constructor(private val loadAdRepository: LoadAdRepository) {

    suspend fun invoke(): Result<Ad> = runCatching {
        loadAdRepository.loadAd()
    }
}
