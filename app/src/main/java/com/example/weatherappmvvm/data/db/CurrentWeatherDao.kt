package com.example.weatherappmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherappmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.example.weatherappmvvm.data.db.entity.CurrentWeatherEntry
import com.example.weatherappmvvm.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id_=$CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>
}