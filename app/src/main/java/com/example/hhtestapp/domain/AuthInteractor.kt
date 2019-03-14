package com.example.hhtestapp.domain

import com.example.hhtestapp.data.AuthRepository
import io.reactivex.Single
import javax.inject.Inject

class AuthInteractor @Inject constructor(val authRepository: AuthRepository) {

    fun loadWeather(): Single<Weather> =
        authRepository.getWeather()
            .map {
                Weather(
                    it.location.name,
                    it.currentWeather.condition.text,
                    it.currentWeather.tempC.toString()
                )
            }
}