package com.example.myfirstapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myfirstapp.R.string
import com.example.myfirstapp.models.CurrentConditions
import com.example.myfirstapp.models.LatitudeLongitude
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    latitudeLongitude: LatitudeLongitude?,
    viewModel: CurrentConditionsViewModel = hiltViewModel(),
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit
) {
    val state by viewModel.currentConditions.collectAsState(initial = null)
    
    if (latitudeLongitude != null) {
        LaunchedEffect(Unit) {
            viewModel.fetchCurrentLocationData(latitudeLongitude)
        }
    } else {
        LaunchedEffect(Unit) {
            viewModel.fetchData()
        }
    }

    Scaffold(
        topBar = { AppBar(title = stringResource(id = string.app_name)) }
    ) {
        state?.let {
            CurrentConditionsContent(it, onGetWeatherForMyLocationClick, onForecastButtonClick)
        }
    }

}

@Composable
private fun CurrentConditionsContent(
    currentConditions: CurrentConditions,
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentConditions.cityName,
            style = TextStyle(
                fontWeight = FontWeight(400),
                fontSize = 22.sp
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = string.temperature, currentConditions.conditions.temperature.roundToInt()),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 72.sp
                    )
                )
                Text(
                    text = stringResource(id = string.feels_like_temp, currentConditions.conditions.feelsLike.roundToInt()),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500)
                )
            }
            Spacer(modifier = Modifier.width(75.dp))
            AsyncImage(
                model = String.format("https://openweathermap.org/img/wn/%s@2x.png", currentConditions.weatherData.firstOrNull()?.iconName),
                modifier = Modifier.size(102.dp),
                contentDescription = "N/A"
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val textStyle = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight(450)
            )
            Text(text = stringResource(id = string.low_temp, currentConditions.conditions.minTemperature.roundToInt()), style = textStyle)
            Text(text = stringResource(id = string.high_temp, currentConditions.conditions.maxTemperature.roundToInt()), style = textStyle)
            Text(text = stringResource(id = string.humidity, currentConditions.conditions.humidity.roundToInt()), style = textStyle)
            Text(text = stringResource(id = string.pressure, currentConditions.conditions.pressure.roundToInt()), style = textStyle)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onForecastButtonClick,
            modifier = Modifier
                .height(40.dp)
                .width(180.dp)) {
            Text(text = stringResource(id = string.forecast))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onGetWeatherForMyLocationClick) {
            Text(text = stringResource(id = string.get_weather_for_my_location))
        }

    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun CurrentConditionsPreview() {
}

