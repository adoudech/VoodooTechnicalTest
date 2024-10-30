package com.skamy.data.http.models

import kotlinx.serialization.Serializable

@Serializable
data class AdResponse(
    val static: String,
    val close_delay: Long,
    val tracking: String,
    val clickThrough: String,
)
