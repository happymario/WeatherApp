package com.mario.weather.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val SplashGradient1 = Color(0xFFF2F4F7)
val SplashGradient2 = Color(0xFFBCC8D6)
val SplashGradient = listOf(SplashGradient1, SplashGradient2)
val SplashTitle = Color(0xFF0A0A22)
val SplashSub = Color(0xFF8B95A2)

// dark를 이용할때 recomposition이 되어야 하므로 mutableStateOf가 되어야 함.
class WeatherColors(
    primary: Color = Purple80,
    splash_gradient: List<Color> = SplashGradient,
    splash_logo_title: Color = SplashTitle,
    splash_logo_sub: Color = SplashSub,
    isDark: Boolean
) {
    var primary by mutableStateOf(Purple80)
        private set
    var splash_gradient by mutableStateOf(SplashGradient)
        private set

    var splash_logo_title by mutableStateOf(SplashTitle)
        private set

    var splash_logo_sub by mutableStateOf(SplashSub)
        private set

    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: WeatherColors) {
        primary = other.primary
        splash_gradient = other.splash_gradient
        splash_logo_title = other.splash_logo_title
        splash_logo_sub = other.splash_logo_sub
        isDark = other.isDark
    }

    fun copy(): WeatherColors = WeatherColors(
        primary = primary,
        splash_gradient = splash_gradient,
        splash_logo_title = splash_logo_title,
        splash_logo_sub = splash_logo_sub,
        isDark = isDark
    )
}

val DarkColorPalette = WeatherColors(
    isDark = true
)

val LightColorPalette = WeatherColors(
    isDark = false
)

val LocalColors = staticCompositionLocalOf { LightColorPalette }