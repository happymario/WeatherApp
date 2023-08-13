package com.mario.weather.data.repository

import com.mario.weather.data.local.room.HistorySearchAddressEntity
import com.mario.weather.data.model.AppInfo
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun setAppInfo(appInfo: AppInfo)

    suspend fun getAppInfo(): Flow<AppInfo>

    fun getSearchAddress(): Flow<List<HistorySearchAddressEntity>>

    suspend fun addSearchAddress(historySearchAddressEntity: HistorySearchAddressEntity)

    suspend fun clearAllSearchAddress()
}
