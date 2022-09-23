package com.example.myfirstapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayForecast(val temp: String) : Parcelable
