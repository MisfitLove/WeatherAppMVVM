package com.example.weatherappmvvm.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry (
    val base: String,
    @Embedded(prefix = "clouds_")
    val clouds: Clouds,
    val cod: Int,
    @Embedded(prefix = "coord_")
    val coord: Coord,
    val dt: Int,
    val id: Int,
    @Embedded(prefix = "main_")
    val main: Main,
    val name: String,
    @Embedded(prefix = "sys_")
    val sys: Sys,
    val visibility: Int,
    @Embedded(prefix = "weather_")
    val weather: List<Weather>,   //trzeba splaszczyc bo room sie na krzywy ryj wyjebie
    val wind: Wind
)