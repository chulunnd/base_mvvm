package com.example.project.ui.mainScreen.home.di

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.example.project.di.module.FactoryModelModule
import com.example.project.ui.mainScreen.home.HomeFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [FactoryModelModule::class, HomeModule::class]
)
interface HomeComponent {
    fun inject(fragment: HomeFragment?)
}