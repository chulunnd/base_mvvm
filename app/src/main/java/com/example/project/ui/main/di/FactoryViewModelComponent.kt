package com.example.project.ui.main.di

import androidx.lifecycle.ViewModelProvider
import com.example.project.di.module.FactoryModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FactoryModelModule::class]
)
interface FactoryViewModelComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory
}