package com.example.myfirstapp.service

import com.example.myfirstapp.models.CurrentConditions
import com.example.myfirstapp.models.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "a6e0d668be777e591817564845e87213",
        @Query("units") units: String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "a6e0d668be777e591817564845e87213",
        @Query("units") units: String = "imperial",
        @Query("cnt") count: String = "16"
    ) : Forecast
}