package com.example.hhtestapp.ui.auth

import com.example.hhtestapp.base.AbstractBasePresenter
import com.example.hhtestapp.di.activity.ActivityScope
import com.example.hhtestapp.domain.AuthInteractor
import javax.inject.Inject

@ActivityScope
class AuthPresenter @Inject constructor(val authInteractor: AuthInteractor) : AbstractBasePresenter<AuthView>() {

}