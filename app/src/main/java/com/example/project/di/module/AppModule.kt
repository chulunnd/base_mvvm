package com.example.project.di.module

import android.content.Context
import com.example.project.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule constructor(application: Application) {

    private val application: Context = application

    @Provides
    fun provideContext(): Context {
        return application;
    }

}