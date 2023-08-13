package com.mario.weather.data.repository

import com.mario.weather.data.local.datastore.PreferenceStorage
import com.mario.weather.data.local.room.HistorySearchAddressDao
import com.mario.weather.data.local.room.HistorySearchAddressEntity
import com.mario.weather.data.model.AppInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    private val searchAddressDao: HistorySearchAddressDao,
) : LocalRepository {

    override suspend fun setAppInfo(appInfo: AppInfo) = preferenceStorage.setModel(appInfo)

    override suspend fun getAppInfo() = preferenceStorage.getModel(AppInfo::class.java)

    override suspend fun addSearchAddress(historySearchAddressEntity: HistorySearchAddressEntity) {
        searchAddressDao.insertOrUpdate(historySearchAddressEntity)
    }

    override suspend fun clearAllSearchAddress() = searchAddressDao.deleteAll()

    override fun getSearchAddress(): Flow<List<HistorySearchAddressEntity>> =
        searchAddressDao.getAll()
}
