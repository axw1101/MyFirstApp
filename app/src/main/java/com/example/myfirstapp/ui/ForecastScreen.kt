package com.example.myfirstapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.R
import com.example.myfirstapp.R.string
import com.example.myfirstapp.models.DayForecast
import com.example.myfirstapp.models.ForecastTemp
import com.example.myfirstapp.toHourMinute
import com.example.myfirstapp.toMonthDay

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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen() {
    Scaffold(
        topBar = { AppBar(title = stringResource(id = string.forecast_title)) }
    ) {
        LazyColumn {
            items(items = forecastData) { item: DayForecast ->
                ForecastRow(item = item)
            }
        }
    }

}

@Composable
private fun ForecastRow(item: DayForecast) {
    Row(
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val textStyle = TextStyle(
            fontSize = 13.sp
        )
        Image(
            painter = painterResource(id = R.drawable.sun_icon),
            contentDescription = "Sunny",
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
                text = stringResource(id = string.forecast_current_temp, 72),
                style = textStyle
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = stringResource(id = string.forecast_high_temp, item.temp.max.toInt()),
                    style = textStyle
                )
                Spacer(modifier = Modifier.width(14.dp))
                Text(
                    text = stringResource(id = string.forecast_low_temp, item.temp.min.toInt()),
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
    ForecastRow(item = forecastData[0])
}