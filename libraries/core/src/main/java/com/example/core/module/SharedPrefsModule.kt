package com.example.core.module

import com.example.core.pref.AppPreferences
import com.example.core.pref.RxPreferences

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPrefsModule {
    @Provides
    @Singleton
    fun provideRxPreference(preferences: AppPreferences): RxPreferences {
        return preferences
    }
}