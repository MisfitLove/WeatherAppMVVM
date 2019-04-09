package com.example.weatherappmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.example.weatherappmvvm.data.db.entity.*

data class MetricCurrentWeatherEntry (
    @ColumnInfo(name = "base")
    override val base: String,
    @Embedded(prefix = "clouds_")
    override val clouds: Clouds,
    @ColumnInfo(name = "cod")
    override val cod: Int,
    @Embedded(prefix = "coord_")
    override val coord: Coord,
    @ColumnInfo(name = "dt")
    override val dt: Int,
    @ColumnInfo(name = "id")
    override val id: Int,
    @Embedded(prefix = "main_")
    override val main: Main,
    @ColumnInfo(name = "name")
    override val name: String,
    @Embedded(prefix = "sys_")
    override val sys: Sys,
    @ColumnInfo(name = "visibility")
    override val visibility: Int,
    @Embedded(prefix = "weather_")
    override val weather: Weather,
    @Embedded(prefix = "wind_")
    override val wind: Wind
) : UnitSpecificCurrentWeatherEntry