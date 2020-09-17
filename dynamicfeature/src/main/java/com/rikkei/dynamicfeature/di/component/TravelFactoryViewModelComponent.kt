package com.rikkei.dynamicfeature.di.component

import androidx.lifecycle.ViewModelProvider
import com.rikkei.dynamicfeature.di.module.TravelFactoryModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [TravelFactoryModelModule::class]
)
interface TravelFactoryViewModelComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory
}