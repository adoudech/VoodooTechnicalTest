package com.skamy.domain.loadad

fun interface LoadAdRepository {

    suspend fun loadAd(): Ad
}