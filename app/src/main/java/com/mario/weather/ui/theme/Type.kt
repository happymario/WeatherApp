package com.mario.weather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mario.weather.R

val DefaultFontFamily = FontFamily(
    listOf(
        Font(R.font.poppins_black, FontWeight.Black),
        Font(R.font.poppins_blackitalic, FontWeight.Black, FontStyle.Italic),
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
        Font(R.font.poppins_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
        Font(R.font.poppins_extralight, FontWeight.ExtraLight),
        Font(R.font.poppins_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
        Font(R.font.poppins_italic, style = FontStyle.Italic),
        Font(R.font.poppins_light, FontWeight.Light),
        Font(R.font.poppins_lightitalic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_mediumitalic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_semibold, FontWeight.SemiBold),
        Font(R.font.poppins_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.poppins_thin, FontWeight.Thin),
        Font(R.font.poppins_thinitalic, FontWeight.Thin, FontStyle.Italic),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)

data class WeatherTypography(
    val heading01: TextStyle = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 38.sp,
        fontSize = 28.sp
    ),
    val heading02: TextStyle = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 32.sp,
        fontSize = 24.sp
    )
)

val LocalTypography = staticCompositionLocalOf { WeatherTypography() }