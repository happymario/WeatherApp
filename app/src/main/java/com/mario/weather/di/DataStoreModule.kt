package com.mario.weather.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.mario.weather.data.local.datastore.DataStorePreferenceStorage
import com.mario.weather.data.local.datastore.PreferenceStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    private val Context.dataStore by preferencesDataStore(DataStorePreferenceStorage.PREFS_NAME)

    @Provides
    fun provideDataStore(@ApplicationContext context: Context): PreferenceStorage =
        DataStorePreferenceStorage(context.dataStore)
}
