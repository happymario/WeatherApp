package com.mario.weather.di

import com.mario.weather.data.local.datastore.PreferenceStorage
import com.mario.weather.data.local.room.HistorySearchAddressDao
import com.mario.weather.data.remote.apiservice.MyWeatherApiService
import com.mario.weather.data.remote.apiservice.OneCallApiService
import com.mario.weather.data.repository.LocalRepository
import com.mario.weather.data.repository.LocalRepositoryImpl
import com.mario.weather.data.repository.WeatherRepository
import com.mario.weather.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideWeatherRepository(
        currentWeatherApiService: MyWeatherApiService,
        oneCallApiService: OneCallApiService,
    ): WeatherRepository = WeatherRepositoryImpl(currentWeatherApiService, oneCallApiService)

    @Provides
    fun provideLocalRepository(
        preferenceStorage: PreferenceStorage, searchAddressDao: HistorySearchAddressDao,
    ): LocalRepository = LocalRepositoryImpl(preferenceStorage, searchAddressDao)
}
