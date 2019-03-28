package com.example.weatherappmvvm.data.network.response

import com.example.weatherappmvvm.data.db.entity.*
import com.serjltt.moshi.adapters.FirstElement

data class CurrentWeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val visibility: Int,
    @FirstElement
    val weather: Weather,
    val wind: Wind
)