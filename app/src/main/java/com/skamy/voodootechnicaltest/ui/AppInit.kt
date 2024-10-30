package com.skamy.voodootechnicaltest.ui

import com.skamy.voodootechnicaltest.AdsInitializer


fun initApplication() {
    initializeThirdParties()
}

private fun initializeThirdParties() {
    AdsInitializer.initialize()
}
