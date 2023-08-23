package com.mario.weather

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberWeatherAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    controller: NavHostController = rememberNavController(),
    drawer: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    snackbarHost: SnackbarHostState = remember { SnackbarHostState() }
): WeatherAppState = remember(coroutineScope, controller, drawer, snackbarHost) {
    WeatherAppState(coroutineScope, controller, drawer, snackbarHost)
}

class WeatherAppState(
    private val coroutineScope: CoroutineScope,
    val controller: NavHostController,
    val drawer: DrawerState,
    val snackbarHost: SnackbarHostState,
) {
    val shouldEnableGesture: Boolean
        @Composable get() = controller.currentBackStackEntryAsState().value?.destination?.route != NestedGraph.SPLASH.route

    fun openDrawer() {
        coroutineScope.launch {
            drawer.open()
        }
    }

    fun closeDrawer() {
        coroutineScope.launch {
            drawer.close()
        }
    }

    fun navigateToHome() {
        closeDrawer()
        controller.navigate(route = NestedGraph.HOME.route) {
            popUpTo(NestedGraph.SPLASH.route) {
                inclusive = true
            }
        }
    }
}

enum class NestedGraph(val route: String) {
    HOME(route = "home_nav"), SPLASH(route = "splash_nav"),
}