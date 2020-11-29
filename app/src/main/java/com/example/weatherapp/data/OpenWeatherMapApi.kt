package com.example.weatherapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("weather?appid=6e1d1df4b40ebd0a98ae90a1550b08a8")
    fun getCurrentWeatherForCity(
        @Query("q")cityAndCountry: String,
        @Query("units")units: String = "metric"
    ) : Call<CityWeatherResponse>

    @GET("forecast?appid=6e1d1df4b40ebd0a98ae90a1550b08a8")
    fun getForecastForCity(
        @Query("q")cityAndCountry: String,
        @Query("units")units: String = "metric"
    ) : Call<ForecastResponse>
}