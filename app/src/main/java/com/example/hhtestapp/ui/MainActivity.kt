package com.example.hhtestapp.ui

import android.os.Bundle
import com.example.hhtestapp.R
import com.example.hhtestapp.base.AbstractBaseActivity

class MainActivity : AbstractBaseActivity<MainView, MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
