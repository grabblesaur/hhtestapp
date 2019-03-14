package com.example.hhtestapp.ui.auth

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
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
        setToolbarWithBackButton(toolbar)
        supportActionBar?.title = getString(R.string.auth)
        signInButton.backgroundTintList = ContextCompat.getColorStateList(this, R.color.tangerine)
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
        val text = String.format("%s: temperature %s °C, condition is %s",  weather.name, weather.temperatureC, weather.condition)
        Snackbar.make(this.window.decorView.findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG).show()
    }

    override fun setProgressBar(flag: Boolean) {
        if (flag) {
            contentLayout.visibility = View.GONE
            progressBarLayout.visibility = View.VISIBLE
        } else {
            contentLayout.visibility = View.VISIBLE
            progressBarLayout.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.auth, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.action_create -> {
                Toast.makeText(this, "${getString(R.string.sign_up)} was pressed", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}