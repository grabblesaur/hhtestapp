package com.example.hhtestapp.data

import com.example.hhtestapp.data.api.Api
import com.example.hhtestapp.data.api.model.WeatherResponse
import io.reactivex.Single
import javax.inject.Inject

class AuthRepository @Inject constructor(val apiService: Api) {

    fun getWeather(): Single<WeatherResponse> = apiService.loadWeather()

}