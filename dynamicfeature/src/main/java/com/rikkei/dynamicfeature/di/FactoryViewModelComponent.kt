package com.rikkei.dynamicfeature.di

import androidx.lifecycle.ViewModelProvider
import com.example.core.scopes.ActivityScope
import com.example.project.di.module.FactoryModelModule
import com.rikkei.dynamicfeature.di.module.TravelFactoryModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [TravelFactoryModelModule::class]
)
interface FactoryViewModelComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory
}