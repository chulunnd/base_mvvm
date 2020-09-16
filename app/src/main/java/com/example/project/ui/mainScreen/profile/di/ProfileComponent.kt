package com.example.project.ui.mainScreen.home.di

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.example.project.di.module.FactoryModelModule
import com.example.project.ui.mainScreen.profile.ProfileFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [FactoryModelModule::class,ProfileModule::class]
)
interface ProfileComponent {
    fun inject(fragment: ProfileFragment?)
}