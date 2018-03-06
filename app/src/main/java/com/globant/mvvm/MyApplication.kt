package com.globant.mvvm

import android.app.Application
import com.globant.mvvm.di.AppComponent
import com.globant.mvvm.di.AppModule
import com.globant.mvvm.di.DaggerAppComponent


class MyApplication : Application() {
    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }

    fun getAppComponent():AppComponent=applicationComponent
}
