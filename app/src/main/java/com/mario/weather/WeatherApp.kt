package com.mario.weather

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mario.weather.home.HomeScreen
import com.mario.weather.splash.SplashScreen

@Composable
fun WeatherApp(appState: WeatherAppState = rememberWeatherAppState()) {

    val localFocusManager = LocalFocusManager.current
    val localContext = LocalContext.current

    ModalNavigationDrawer(
        drawerState = appState.drawer,
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures {
                localFocusManager.clearFocus()
            }
        },
        gesturesEnabled = appState.shouldEnableGesture,
        drawerContent = {
            ModalDrawerSheet {

            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
        ) {
            NavHost(
                navController = appState.controller,
                startDestination = NestedGraph.SPLASH.route,
                modifier = Modifier.padding(it)
            ) {
                composable(NestedGraph.SPLASH.route) { from ->
                    SplashScreen()
                }
                composable(NestedGraph.HOME.route) { from ->
                    HomeScreen()
                }
            }
        }
    }
}