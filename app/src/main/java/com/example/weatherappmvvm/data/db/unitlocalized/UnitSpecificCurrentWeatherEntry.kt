package com.example.weatherappmvvm.data.db.unitlocalized

import com.example.weatherappmvvm.data.db.entity.*

interface UnitSpecificCurrentWeatherEntry {
    val base: String
    val clouds: Clouds
    val cod: Int
    val coord: Coord
    val dt: Int
    val id: Int
    val main: Main
    val name: String
    val sys: Sys
    val visibility: Int
    val weather: Weather
    val wind: Wind
}