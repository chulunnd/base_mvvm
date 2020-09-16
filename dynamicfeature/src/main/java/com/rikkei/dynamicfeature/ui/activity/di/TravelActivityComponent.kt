package com.example.project.ui.mainScreen.home.di

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.rikkei.dynamicfeature.di.FactoryViewModelComponent
import com.rikkei.dynamicfeature.di.module.TravelFragmentModule
import com.rikkei.dynamicfeature.ui.activity.TravelActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class, FactoryViewModelComponent::class],
    modules = [TravelFragmentModule::class, TravelActivityModule::class]
)
interface TravelActivityComponent {
    fun inject(fragment: TravelActivity?)
}