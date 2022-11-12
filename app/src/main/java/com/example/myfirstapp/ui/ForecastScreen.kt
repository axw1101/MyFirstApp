package com.example.myfirstapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myfirstapp.R.string
import com.example.myfirstapp.models.ForecastData
import com.example.myfirstapp.toHourMinute
import com.example.myfirstapp.toMonthDay
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
) {
    val state by viewModel.forecast.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    Scaffold(
        topBar = { AppBar(title = stringResource(id = string.forecast_title)) }
    ) {
        LazyColumn {
            state?.let { it1 ->
                items(items = it1.forecastConditions) { item: ForecastData ->
                    ForecastRow(item = item)
                }
            }
        }
    }

}

@Composable
private fun ForecastRow(item: ForecastData) {
    Row(
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val textStyle = TextStyle(
            fontSize = 13.sp
        )
        AsyncImage(
            model = String.format("https://openweathermap.org/img/wn/%s@2x.png", item.forecastWeatherData.firstOrNull()?.iconName),
            contentDescription = "N/A",
            modifier = Modifier.size(75.dp)
        )
        Text(
            text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 15.sp
            )
        )
        Spacer(modifier = Modifier.padding(start = 24.dp))
        Column {
            Text(
                text = stringResource(id = string.forecast_current_temp, item.temperature.dayTemperature.roundToInt()),
                style = textStyle
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = stringResource(id = string.forecast_high_temp, item.temperature.highTemperature.roundToInt()),
                    style = textStyle
                )
                Spacer(modifier = Modifier.width(14.dp))
                Text(
                    text = stringResource(id = string.forecast_low_temp, item.temperature.lowTemperature.roundToInt()),
                    style = textStyle
                )
            }
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = stringResource(id = string.forecast_sunrise, item.sunrise.toHourMinute().lowercase()),
                style = textStyle
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = string.forecast_sunset, item.sunset.toHourMinute().lowercase()),
                style = textStyle
            )
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun ForecastRowPreview() {
}