package com.example.project.ui.mainScreen.home.di

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.rikkei.dynamicfeature.di.module.TravelApiModule
import com.rikkei.dynamicfeature.di.module.TravelFactoryModelModule
import com.rikkei.dynamicfeature.di.module.TravelFragmentModule
import com.rikkei.dynamicfeature.ui.activity.TravelActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [TravelFactoryModelModule::class, TravelFragmentModule::class, TravelActivityModule::class, TravelApiModule::class]
)
interface TravelActivityComponent {
    fun inject(fragment: TravelActivity?)
}