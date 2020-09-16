package com.example.project.di.component

import android.content.Context
import com.example.core.bus.RxBus
import com.example.core.module.ApiModule
import com.example.core.module.DatabaseModule
import com.example.core.module.RxModule
import com.example.core.module.SharedPrefsModule
import com.example.core.navigationComponent.BaseNavigator
import com.example.core.pref.RxPreferences
import com.example.core.rx.RxSchedulers
import com.example.project.di.module.AppModule
import com.example.project.di.module.NavigationModule
import com.example.project.navigation.AppNavigation
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RxModule::class,
        SharedPrefsModule::class,
        DatabaseModule::class,
        NavigationModule::class,
        ApiModule::class
    ]
)
interface AppComponent {
    fun getAppContext(): Context
    fun provideRxSchedulers(): RxSchedulers
    fun provideRxBus(): RxBus
    fun provideRxPreference(): RxPreferences
    fun provideBaseNavigation(): BaseNavigator
    fun provideAppNavigation(): AppNavigation
}