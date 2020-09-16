package com.example.project.ui.mainScreen.home.di

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.example.project.di.module.MainViewModule
import com.example.project.di.module.FactoryModelModule
import com.example.project.ui.mainScreen.MainFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [FactoryModelModule::class,MainViewModule::class]
)
interface MainComponent {
    fun inject(fragment: MainFragment?)
}