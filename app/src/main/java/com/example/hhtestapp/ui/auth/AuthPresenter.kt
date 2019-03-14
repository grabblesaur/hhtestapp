package com.example.hhtestapp.ui.auth

import android.util.Log
import com.example.hhtestapp.Validator
import com.example.hhtestapp.base.AbstractBasePresenter
import com.example.hhtestapp.di.activity.ActivityScope
import com.example.hhtestapp.domain.AuthInteractor
import com.example.hhtestapp.domain.Weather
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class AuthPresenter @Inject constructor(val authInteractor: AuthInteractor) : AbstractBasePresenter<AuthView>() {

    fun signIn(email: String, password: String) {
        getView()?.refreshErrorState()
        Single.just(Pair(email, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                if (!Validator.isEmailValid(it.first)) throw Throwable("Некорректный email")
                it.second
            }
            .map {
                if (it.length < 6) throw Throwable("Пароль должен содержать минимум 6 символов")
                it
            }
            .map {
                if (Validator.hasSymbol(it)) throw Throwable("Пароль не должен содержать специальных символов")
                it
            }
            .map {
                if (!(Validator.hasDigit(it) && Validator.hasUpperCase(it) && Validator.hasLowerCase(it)))
                    throw Throwable("Пароль должен содержать минимум 1 строчную букву, 1 заглавную, и 1 цифру.")
            }
            .subscribe(object : SingleObserver<Unit> {
                var disposable: Disposable? = null
                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }
                override fun onSuccess(t: Unit) {
                    loadWeather()
                    disposeCheck(disposable)
                }
                override fun onError(e: Throwable) {
                    getView()?.onInputError(e)
                    disposeCheck(disposable)
                }
            })
    }

    private fun loadWeather() {
        authInteractor.loadWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Weather> {
                var disposable: Disposable? = null
                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }
                override fun onSuccess(t: Weather) {
                    getView()?.showWeather(t)
                }
                override fun onError(e: Throwable) {
                    getView()?.onError(e)
                }
            })
    }
}
