package com.example.project.ui.mainScreen.home.di

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.example.project.di.module.FactoryModelModule
import com.example.project.ui.main.di.FactoryViewModelComponent
import com.example.project.ui.mainScreen.notice.NoticeFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class, FactoryViewModelComponent::class],
    modules = [ProfileModule::class]
)
interface NoticeComponent {
    fun inject(fragment: NoticeFragment?)
}