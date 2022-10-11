package com.example.myfirstapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(title: String) {
    TopAppBar {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = title,
            style = TextStyle(
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight(700),
            )
        )
    }
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar(title = "Weather App")
}