package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class CityWeatherResponse(
    val name: String,
    val weather: List<WeatherItem>,
    val main: Main,
    val sys: Sys,
    val wind: Wind
) {
    data class WeatherItem(
        val main: String,
        val description: String
    )

    data class Main(
        val temp: Float,
        val humidity: Int
    )

    data class Sys(
        val country: String
    )

    data class Wind(
        val speed: Float
    )
}

data class ForecastResponse(
    val city: City,
    val list: List<ListItem>
) {
    data class City(
        val name: String,
        val country: String
    )
    data class ListItem(
        val main: Main,
        val weather: List<WeatherItem>,
        @SerializedName("dt_txt") val dateTime: Date
    ) {
        data class Main (
            val temp: Float
        )
        data class WeatherItem (
            val description: String
        )
    }
}