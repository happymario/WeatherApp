package com.mario.weather.data.repository

import com.mario.weather.data.model.AppInfo
import com.mario.weather.data.remote.apiservice.MyWeatherApiService
import com.mario.weather.data.remote.apiservice.OneCallApiService
import com.mario.weather.data.remote.response.ResponseTransfomer.trasformBaseResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val myWeatherApiService: MyWeatherApiService,
    private val oneCallApiService: OneCallApiService,
) : WeatherRepository {
    override suspend fun getAppInfo(): Flow<AppInfo> =
        trasformBaseResponse(myWeatherApiService.appInfo("android"))
}