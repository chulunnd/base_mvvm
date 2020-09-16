package com.example.project

import android.app.Application
import com.example.project.di.component.AppComponent
import com.example.project.di.component.DaggerAppComponent
import com.example.project.di.module.AppModule
import com.example.recyclerviewmvvm.BuildConfig
import timber.log.Timber

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var component: AppComponent
    }
}