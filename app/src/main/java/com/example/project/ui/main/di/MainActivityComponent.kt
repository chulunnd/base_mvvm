package com.example.project.ui.main.di

import androidx.lifecycle.ViewModelProvider
import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.example.project.di.module.FactoryModelModule
import com.example.project.di.module.MainViewModule
import com.example.project.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class,FactoryViewModelComponent::class],
    modules = [MainViewModule::class]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}