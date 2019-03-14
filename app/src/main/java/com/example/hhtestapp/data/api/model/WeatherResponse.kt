package com.example.hhtestapp.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeather: CurrentWeather
)