package com.skamy.data.loadad

import com.skamy.data.http.HttpClientApi
import com.skamy.domain.loadad.Ad
import com.skamy.domain.loadad.LoadAdRepository

private const val AD_URL = "https://voodoo-adn-framework.s3.eu-west-1.amazonaws.com/test/ad.json"

internal class LoadAdDataRepository(
    private val httpClientApi: HttpClientApi,
    private val adMapper: AdMapper,
) : LoadAdRepository {
    override suspend fun loadAd(): Ad = adMapper.map(httpClientApi.getAd(AD_URL))
}
