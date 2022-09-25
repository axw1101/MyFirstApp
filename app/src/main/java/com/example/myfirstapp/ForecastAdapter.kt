package com.example.myfirstapp

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.roundToInt

class ForecastAdapter(private val data: List<DayForecast>) : RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val forecastIcon: ImageView
    private val forecastDate: TextView
    private val forecastTemp: TextView
    private val forecastTempHigh: TextView
    private val forecastTempLow: TextView
    private val forecastSunrise: TextView
    private val forecastSunset: TextView

    init {
        forecastDate = view.findViewById(R.id.forecast_date)
        forecastIcon = view.findViewById(R.id.forecast_icon)
        forecastTemp = view.findViewById(R.id.forecast_temp)
        forecastTempHigh = view.findViewById(R.id.forecast_temp_high)
        forecastTempLow = view.findViewById(R.id.forecast_temp_low)
        forecastSunrise = view.findViewById(R.id.forecast_sunrise)
        forecastSunset = view.findViewById(R.id.forecast_sunset)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(data: DayForecast) {
        forecastDate.text = formatDate(data.date)
        forecastIcon.setImageResource(R.drawable.sun_icon)
        forecastTemp.text = itemView.context.getString(R.string.forecast_current_temp)
        forecastTempHigh.text = itemView.context.getString(R.string.forecast_high_temp, data.temp.max.roundToInt())
        forecastTempLow.text = itemView.context.getString(R.string.forecast_low_temp, data.temp.min.roundToInt())
        forecastSunrise.text = itemView.context.getString(R.string.forecast_sunrise, formatTime(data.sunrise))
        forecastSunset.text = itemView.context.getString(R.string.forecast_sunset, formatTime(data.sunset))
    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDate(dateTimeStamp: Long) : String {
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(dateTimeStamp), TimeZone.getDefault().toZoneId())
//        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp, 0, ZoneOffset.of("-5"))
        return formatter.format(dateTime)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatTime(dateTimeStamp: Long) : String {
        val formatter = DateTimeFormatter.ofPattern("h:mma")
        val dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(dateTimeStamp), TimeZone.getDefault().toZoneId())
        return formatter.format(dateTime).lowercase()
    }
}