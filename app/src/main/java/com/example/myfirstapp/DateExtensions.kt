package com.example.myfirstapp

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun Long.toMonthDay(): String {
    val dateFormatter = DateTimeFormatter.ofPattern("MMM dd")
    val dateTime = LocalDateTime.ofEpochSecond(this, 0, ZoneOffset.of("-5"))
    return dateFormatter.format(dateTime)
}

fun Long.toHourMinute(): String {
    val dateFormatter = DateTimeFormatter.ofPattern("h:mma")
    val dateTime = LocalDateTime.ofEpochSecond(this, 0, ZoneOffset.of("-5"))
    return dateFormatter.format(dateTime)
}