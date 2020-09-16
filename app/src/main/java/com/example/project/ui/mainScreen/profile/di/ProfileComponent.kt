package com.example.project.ui.mainScreen.home.di

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.example.project.ui.main.di.FactoryViewModelComponent
import com.example.project.ui.mainScreen.profile.ProfileFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class, FactoryViewModelComponent::class],
    modules = [ProfileModule::class]
)
interface ProfileComponent {
    fun inject(fragment: ProfileFragment?)
}