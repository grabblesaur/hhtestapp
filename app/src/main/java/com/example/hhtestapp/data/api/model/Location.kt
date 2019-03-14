package com.example.hhtestapp.data.api.model

import com.google.gson.annotations.SerializedName

data class Location (
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("tz_id")
    val tzId: String,
    @SerializedName("localtime_epoch")
    val localTimeEpoch: Long,
    val localtime: String
)