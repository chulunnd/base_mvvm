package com.example.project.ui.mainScreen.home.di

import androidx.lifecycle.ViewModelProvider
import com.example.core.base.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class ProfileModule {
//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    @Binds
    @Named("name")
    abstract fun bindName(name: String): String
}