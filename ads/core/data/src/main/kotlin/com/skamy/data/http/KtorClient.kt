package com.skamy.data.http

import com.skamy.data.http.models.AdResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class KtorClient(private val httpClient: HttpClient) : HttpClientApi {
    override suspend fun getAd(adUrl: String): AdResponse {
        return httpClient.get(adUrl).body()
    }
}
