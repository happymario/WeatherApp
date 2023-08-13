package com.mario.weather.data.repository

import com.mario.weather.data.model.AppInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getAppInfo(): Flow<AppInfo>
}
