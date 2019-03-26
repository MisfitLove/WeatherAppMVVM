package com.example.weatherappmvvm.data

import com.example.weatherappmvvm.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "d89ea3223550cce5f93302b93165f31e"

//http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22

interface OpenWeatherApiService {

    @GET ("weather")
    //TODO specyfikacja miasta?
    fun getCurrentWeather(
        @Query ("q") location: String,
        @Query("appid") key: String = API_KEY
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(): OpenWeatherApiService {
            val okHttpClient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OpenWeatherApiService::class.java)
        }
    }
}