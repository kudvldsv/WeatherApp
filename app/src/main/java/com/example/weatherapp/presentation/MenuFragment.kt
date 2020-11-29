package com.example.weatherapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        currentWeatherBtn.setOnClickListener { navigate(CityWeatherFragment()) }
        forecastBtn.setOnClickListener{ navigate(ForecastFragment()) }

    }

    private fun navigate(fragment: Fragment) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.navHost, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}