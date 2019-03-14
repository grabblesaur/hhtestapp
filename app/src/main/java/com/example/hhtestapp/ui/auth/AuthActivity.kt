package com.example.hhtestapp.ui.auth

import android.os.Bundle
import android.widget.Toast
import com.example.hhtestapp.R
import com.example.hhtestapp.base.AbstractBaseActivity
import com.example.hhtestapp.domain.Weather
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AbstractBaseActivity<AuthView, AuthPresenter>(), AuthView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initViews()
    }

    private fun initViews() {
        signInButton.setOnClickListener {
            hideSoftKeyBoard()
            presenter.signIn(emailEditText.text.toString(), passwordEditText.text.toString())
        }
    }

    override fun refreshErrorState() {
        emailInputLayout.error = null
        passwordInputLayout.error = null
    }

    override fun onInputError(throwable: Throwable) {
        if (throwable.message?.contains("email")!!) {
            emailInputLayout.error = throwable.message
        }

        if (throwable.message?.contains("Пароль")!!) {
            passwordInputLayout.error = throwable.message
        }
    }

    override fun showWeather(weather: Weather) {
        val text = String.format("%s, %s C, %s",  weather.name, weather.temperatureC, weather.condition)
        Snackbar.make(this.window.decorView.findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG).show()
    }
}