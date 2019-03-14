package com.example.hhtestapp.ui.auth

import android.os.Bundle
import com.example.hhtestapp.R
import com.example.hhtestapp.base.AbstractBaseActivity

class AuthActivity : AbstractBaseActivity<AuthView, AuthPresenter>(), AuthView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initViews()
    }

    private fun initViews() {

    }
}