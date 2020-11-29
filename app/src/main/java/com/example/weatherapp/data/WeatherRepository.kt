package com.example.weatherapp.data

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    private val coroutineContext = Dispatchers.IO
    private val openWeatherMapApi = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create()
            ))
        .build()
        .create(OpenWeatherMapApi::class.java)

    suspend fun getCurrentWeatherForCity(city: String, countryCode: String) = withContext(coroutineContext) {
        val cityAndCode = "$city, $countryCode"

        openWeatherMapApi.getCurrentWeatherForCity(cityAndCode)
            .execute()
            .body()
    }
    suspend fun getForecastForCity(city: String, countryCode: String) = withContext(coroutineContext) {
        val cityAndCode = "$city, $countryCode"

        openWeatherMapApi.getForecastForCity(cityAndCode)
            .execute()
            .body()
    }
}