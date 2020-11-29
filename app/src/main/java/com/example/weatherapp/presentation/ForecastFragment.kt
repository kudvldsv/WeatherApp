package com.example.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherRepository
import kotlinx.android.synthetic.main.fragment_forecast.*
import kotlinx.android.synthetic.main.fragment_current_city_weather.*
import kotlinx.android.synthetic.main.layout_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ForecastFragment : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main

    private val repository = WeatherRepository()

    private val adapter = ForecastAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forecast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        forecastList.adapter = adapter

        searchButton.setOnClickListener {
            val inputCity = inputCity.text.toString()
            val inputCountryCode = inputCountryCode.text.toString()

            if (inputCity.isEmpty() || inputCity.isBlank()) return@setOnClickListener

            launch {
                val response = repository.getForecastForCity(inputCity, inputCountryCode)
                response?.apply {
                    adapter.updateForecasts(list)
                }
            }
        }
    }

}