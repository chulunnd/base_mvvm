package com.rikkei.dynamicfeature.di.module

import androidx.lifecycle.ViewModel
import com.example.core.base.ViewModelKey
import com.example.core.scopes.ActivityScope
import com.example.core.scopes.FragmentScope
import com.rikkei.dynamicfeature.navigation.TravelNavigation
import com.rikkei.dynamicfeature.navigation.TravelNavigationImpl
import com.rikkei.dynamicfeature.ui.activity.TravelModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TravelFragmentModule {
    @Binds
    @ActivityScope
    abstract fun provideTravelNavigation(travelNavigationImpl: TravelNavigationImpl): TravelNavigation
}