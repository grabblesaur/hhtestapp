package com.example.hhtestapp.ui.main

import com.example.hhtestapp.base.AbstractBasePresenter
import com.example.hhtestapp.di.activity.ActivityScope
import com.example.hhtestapp.domain.MainInteractor
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor(val mainInteractor: MainInteractor) : AbstractBasePresenter<MainView>() {

}