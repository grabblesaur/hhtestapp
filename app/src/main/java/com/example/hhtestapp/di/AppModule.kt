package com.example.hhtestapp.di

import com.example.hhtestapp.di.activity.ActivityScope
import com.example.hhtestapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}
