package com.example.weatherappmvvm.data

import com.example.weatherappmvvm.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.serjltt.moshi.adapters.FirstElement
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "d89ea3223550cce5f93302b93165f31e"

//http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22
//class WeatherAdapter{
//    @ToJson
//    fun toJson(): String {
//        return "nic tu nie musi byc"
//    }
//
//    @FromJson
//    fun fromJson(weatherList: List<Weather>): Weather {
//
//        return weatherList.first()
//    }
//} nie wiem czemu to nie działa jebać to grrr

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

            val moshi = Moshi.Builder().add(FirstElement.ADAPTER_FACTORY).build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(OpenWeatherApiService::class.java)
        }
    }
}