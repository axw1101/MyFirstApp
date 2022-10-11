package com.example.myfirstapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.R
import com.example.myfirstapp.R.string

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    onForecastButtonClick: () -> Unit
) {
    Scaffold(
        topBar = { AppBar(title = stringResource(id = string.app_name)) }
    ) {
        CurrentConditionsContent {
            onForecastButtonClick()
        }
    }

}

@Composable
private fun CurrentConditionsContent(
    onForecastButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = string.city_name),
            style = TextStyle(
                fontWeight = FontWeight(600),
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
                    text = stringResource(id = string.current_temp),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 72.sp
                    )
                )
                Text(text = stringResource(id = string.feels_like_temp, 78))
            }
            Spacer(modifier = Modifier.width(75.dp))
            Image(
                modifier = Modifier.size(102.dp),
                painter = painterResource(R.drawable.sun_icon),
                contentDescription = "Sunny"
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
            )
            Text(text = stringResource(id = string.low_temp, 65), style = textStyle)
            Text(text = stringResource(id = string.high_temp, 80), style = textStyle)
            Text(text = stringResource(id = string.humidity, 100), style = textStyle)
            Text(text = stringResource(id = string.pressure, 1023), style = textStyle)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onForecastButtonClick,
            modifier = Modifier.height(40.dp).width(180.dp)) {
            Text(text = stringResource(id = string.forecast))
        }

    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun CurrentConditionsPreview() {
    CurrentConditions {}
}

