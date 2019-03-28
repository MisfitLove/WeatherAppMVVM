package com.example.weatherappmvvm.data.db.entity

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Main(
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    //@SerializedName("temp_max")
    @Json(name = "temp_max")
    val tempMax: Double,
    //@SerializedName("temp_min")
    @Json(name = "temp_min")
    val tempMin: Double
)