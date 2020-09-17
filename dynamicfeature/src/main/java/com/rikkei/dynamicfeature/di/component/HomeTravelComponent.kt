package com.rikkei.dynamicfeature.di.component

import com.example.core.scopes.ActivityScope
import com.example.project.di.component.AppComponent
import com.rikkei.dynamicfeature.di.module.HomeTravelModule
import com.rikkei.dynamicfeature.di.module.TravelFragmentModule
import com.rikkei.dynamicfeature.ui.fragment.home.HomeTravelFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class, TravelFactoryViewModelComponent::class],
    modules = [TravelFragmentModule::class, HomeTravelModule::class]
)
interface HomeTravelComponent {
    fun inject(fragment: HomeTravelFragment?)
}