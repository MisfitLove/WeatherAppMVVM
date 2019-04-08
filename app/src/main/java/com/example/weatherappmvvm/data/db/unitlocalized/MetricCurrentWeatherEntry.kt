package com.example.weatherappmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo
import com.example.weatherappmvvm.data.db.entity.*

data class MetricCurrentWeatherEntry (
    override val base: String,
    @ColumnInfo(name = "clouds_")
    override val clouds: Clouds,
    override val cod: Int,
    @ColumnInfo(name = "coord_")
    override val coord: Coord,
    override val dt: Int,
    override val id: Int,
    @ColumnInfo(name = "main_")
    override val main: Main,
    override val name: String,
    @ColumnInfo(name = "sys_")
    override val sys: Sys,
    override val visibility: Int,
    @ColumnInfo(name = "weather_")
    override val weather: Weather,
    @ColumnInfo(name = "wind_")
    override val wind: Wind
) : UnitSpecificCurrentWeatherEntry