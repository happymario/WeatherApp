package com.mario.weather.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mario.weather.R
import com.mario.weather.WeatherAppState
import com.mario.weather.ui.theme.CustomTheme
import com.mario.weather.ui.theme.MyWeatherTheme
import com.mario.weather.ui.theme.SplashGradient1
import com.mario.weather.ui.theme.SplashGradient2

@Composable
fun Splash(appState: WeatherAppState) {
    SplashScreen(onNavHome = appState::navigateToHome)
}

@Composable
fun SplashScreen(onNavHome: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(SplashGradient1, SplashGradient2),
                ),
                shape = RectangleShape,
                alpha = 1.0f
            )
    ) {
        Column (
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "logo",
                modifier = Modifier.size(240.dp, 180.dp)
            )
            Text(text = stringResource(id = R.string.splash_logo1), style = CustomTheme.typography.heading01)
            Text(text = stringResource(id = R.string.splash_logo2) , style = CustomTheme.typography.heading02)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyWeatherTheme {
        SplashScreen()
    }
}