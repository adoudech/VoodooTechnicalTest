package com.skamy.data.loadad

import com.skamy.data.http.models.AdResponse
import com.skamy.domain.loadad.Ad

internal class AdMapper {

    fun map(adResponse: AdResponse): Ad = Ad(
        url = adResponse.static,
        closeDelay = adResponse.close_delay,
        trackingUrl = adResponse.tracking,
        clickThrougUrl = adResponse.clickThrough,
    )
}
