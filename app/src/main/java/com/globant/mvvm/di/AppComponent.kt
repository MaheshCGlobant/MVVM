package com.globant.mvvm.di

import com.globant.mvvm.MyApplication

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(myApplication: MyApplication)

    fun plus(fragmentModule: FragmentModule): FragmentComponent
}