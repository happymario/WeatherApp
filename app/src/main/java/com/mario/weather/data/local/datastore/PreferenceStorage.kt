package com.mario.weather.data.local.datastore

import com.mario.weather.base.BaseModel
import kotlinx.coroutines.flow.Flow

interface PreferenceStorage {
    suspend fun <T : BaseModel> setModel(model: T?)
    suspend fun <T : BaseModel> removeModel(type: Class<T>)
    suspend fun <T : BaseModel?> getModel(type: Class<T>): Flow<T>
}
