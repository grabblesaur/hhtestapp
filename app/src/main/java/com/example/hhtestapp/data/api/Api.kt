package com.example.hhtestapp.data.api

import com.example.hhtestapp.data.api.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    companion object {
        const val PARIS = "current.json?key=871051d325b5431b8e181249191403&q=Moscow"
    }

    @GET(PARIS)
    fun loadWeather(): Single<WeatherResponse>
}