package com.mario.weather.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistorySearchAddressEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun historySearchAddressDao(): HistorySearchAddressDao

    companion object {
        const val database_name = "weather_database"
    }
}
