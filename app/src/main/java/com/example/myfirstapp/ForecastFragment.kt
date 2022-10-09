package com.example.myfirstapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myfirstapp.databinding.FragmentForecastBinding

private val forecastData = listOf(
    DayForecast(1664048400, 1664024400, 1664071200, ForecastTemp(65f, 80f), 0f, 0),
    DayForecast(1664134800, 1664111100, 1664157300, ForecastTemp(70f, 82f), 1f, 1),
    DayForecast(1664221200, 1664197800, 1664243400, ForecastTemp(75f, 88f), 2f, 2),
    DayForecast(1664307600, 1664284500, 1664329500, ForecastTemp(86f, 92f), 3f, 3),
    DayForecast(1664394000, 1664371200, 1664415600, ForecastTemp(88f, 98f), 4f, 4),
    DayForecast(1664480400, 1664457900, 1664501700, ForecastTemp(76f, 90f), 5f, 5),
    DayForecast(1664566800, 1664544600, 1664587800, ForecastTemp(72f, 84f), 6f, 6),
    DayForecast(1664653200, 1664631300, 1664673900, ForecastTemp(68f, 86f), 7f, 7),
    DayForecast(1664739600, 1664718000, 1664760000, ForecastTemp(89f, 100f), 8f, 8),
    DayForecast(1664826000, 1664804700, 1664846100, ForecastTemp(85f, 97f), 9f, 9),
    DayForecast(1664912400, 1664891400, 1664932200, ForecastTemp(83f, 95f), 10f, 10),
    DayForecast(1664998800, 1664978100, 1665018300, ForecastTemp(79f, 93f), 11f, 11),
    DayForecast(1665085200, 1665064800, 1665104400, ForecastTemp(77f, 91f), 12f, 12),
    DayForecast(1665171600, 1665151500, 1665190500, ForecastTemp(71f, 89f), 13f, 13),
    DayForecast(1665258000, 1665238200, 1665276600, ForecastTemp(66f, 87f), 14f, 14),
    DayForecast(1665344400, 1665324900, 1665362700, ForecastTemp(73f, 85f), 15f, 15)
)

class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.forecast_fragment_title)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)
    }
}