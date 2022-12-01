package com.example.myfirstapp.models

import com.squareup.moshi.Json

data class Forecast(
    @Json(name = "list") val forecastConditions: List<ForecastData>
)

data class ForecastData(
    @Json(name = "dt") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "temp") val temperature: ForecastTemp,
    @Json(name = "weather") val forecastWeatherData: List<ForecastWeatherData>
)

data class ForecastTemp(
    @Json(name = "day") val dayTemperature: Float,
    @Json(name = "min") val lowTemperature: Float,
    @Json(name = "max") val highTemperature: Float
)

data class ForecastWeatherData(
    @Json(name = "icon") val iconName: String
)

