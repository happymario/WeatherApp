package com.mario.weather.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.google.gson.Gson
import com.mario.weather.base.BaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataStorePreferenceStorage @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : PreferenceStorage {

    override suspend fun <T : BaseModel> setModel(model: T?) {
        val key: String = PreferenceKeys.PREFS_MODEL.name + model?.javaClass?.name
        val value = if (model == null) "" else Gson().toJson(model)

        val preferencesKey = stringPreferencesKey(key)
        dataStore.setValue { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun <T : BaseModel> removeModel(type: Class<T>) {
        val key: String = PreferenceKeys.PREFS_MODEL.name + type.name
        val preferencesKey = stringPreferencesKey(key)
        dataStore.setValue { preferences ->
            preferences[preferencesKey] = ""
        }
    }

    override suspend fun <T : BaseModel?> getModel(type: Class<T>): Flow<T> {
        val key: String = PreferenceKeys.PREFS_MODEL.name + type.name
        val preferencesKey = stringPreferencesKey(key)
        val preferences = dataStore.data.first()
        return flow { Gson().fromJson(preferences[preferencesKey], type) }
    }

    object PreferenceKeys {
        val PREFS_MODEL = stringSetPreferencesKey("PREFS_MODEL")
    }

    companion object {
        const val PREFS_NAME = "my_weather_datastore"
    }
}
