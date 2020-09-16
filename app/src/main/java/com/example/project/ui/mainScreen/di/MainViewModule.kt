package com.example.project.ui.main.di

import dagger.Binds
import dagger.Module
import javax.inject.Named


@Module
abstract class MainViewModule {

    @Binds
    @Named("name")
    abstract fun bindName(name: String): String
}