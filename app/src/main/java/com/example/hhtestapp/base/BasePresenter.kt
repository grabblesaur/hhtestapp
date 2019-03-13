package com.example.hhtestapp.base

interface BasePresenter<in T : BaseView> {

    fun takeView(t: T)

    fun detachFromView()
}
