package com.skamy.data

import android.system.Os.bind
import com.skamy.data.http.HttpClientApi
import com.skamy.data.http.KtorClient
import com.skamy.data.loadad.AdMapper
import com.skamy.data.loadad.LoadAdDataRepository
import com.skamy.domain.loadad.LoadAdRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.compression.ContentEncoding
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {

    // HTTP
    single {
        createClient(
            baseUrl = "https://voodoo-adn-framework.s3.eu-west-1.amazonaws.com/test/ad.json",
            isDebug = true,
        )
    }

    singleOf(::KtorClient) { bind<HttpClientApi>() }

    // Mappers
    factoryOf(::AdMapper)

    // Repositories
    singleOf(::LoadAdDataRepository) { bind<LoadAdRepository>() }
}

private fun createClient(
    baseUrl: String,
    isDebug: Boolean,
): HttpClient = HttpClient().config {
    install(ContentEncoding) {
        gzip()
        deflate()
    }

    install(DefaultRequest) {
        url(baseUrl)
    }

    install(Logging) {
        logger = io.ktor.client.plugins.logging.Logger.SIMPLE
        level = getLogLevel(isDebug)
    }
}

private fun getLogLevel(debug: Boolean): LogLevel =
    if (debug) LogLevel.ALL else LogLevel.NONE
