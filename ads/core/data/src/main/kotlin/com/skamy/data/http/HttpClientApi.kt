package com.skamy.data.http

import com.skamy.data.http.models.AdResponse

interface HttpClientApi {

    suspend fun getAd(adUrl: String): AdResponse
}