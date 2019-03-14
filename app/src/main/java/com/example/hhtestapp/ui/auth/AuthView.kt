package com.example.hhtestapp.ui.auth

import com.example.hhtestapp.base.BaseView
import com.example.hhtestapp.domain.Weather

interface AuthView : BaseView {
    fun refreshErrorState()
    fun onInputError(throwable: Throwable)
    fun showWeather(weather: Weather)
    fun setProgressBar(flag: Boolean)
}