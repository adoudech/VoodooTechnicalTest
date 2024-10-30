package com.skamy.voodootechnicaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.skamy.voodootechnicaltest.ui.screen.MainScreen
import com.skamy.voodootechnicaltest.ui.theme.VoodooTechnicalTestTheme
import com.skamy.voodootechnicaltest.ui.initApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initApplication()
        enableEdgeToEdge()
        setContent {
            VoodooTechnicalTestTheme {
                MainScreen()
            }
        }
    }
}
