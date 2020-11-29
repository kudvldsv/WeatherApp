package com.example.weatherapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.ForecastResponse
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>(){

    private var forecasts = listOf<ForecastResponse.ListItem>()

    fun updateForecasts(forecasts: List<ForecastResponse.ListItem>) {
        this.forecasts = forecasts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecasts[position])
    }

    override fun getItemCount(): Int = forecasts.size


    class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(forecast: ForecastResponse.ListItem) = itemView.apply {
            forecast.let {
                dateTime.text = it.dateTime.toString()
                weatherDescriptionAndTemp.text = resources.getString(R.string.desc_and_temp_format)
                    .format(it.weather[0].description, it.main.temp)
            }
        }
    }
}