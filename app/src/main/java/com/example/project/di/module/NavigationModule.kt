package com.example.project.di.module

import com.example.core.navigationComponent.BaseNavigator

import com.example.project.navigation.AppNavigation
import com.example.project.navigation.AppNavigatorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideBaseNavigation(navigation: AppNavigatorImpl): BaseNavigator {
        return navigation
    }

    @Provides
    @Singleton
    fun provideAppNavigation(navigation: AppNavigatorImpl): AppNavigation {
        return navigation
    }
}