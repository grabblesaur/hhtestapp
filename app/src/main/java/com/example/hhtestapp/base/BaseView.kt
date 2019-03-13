package com.example.hhtestapp.base

interface BaseView {
    fun onError(message: String?)
    fun onError(throwable: Throwable?)
}
