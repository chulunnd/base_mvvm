package com.rikkei.dynamicfeature.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.base.ViewModelFactory
import com.example.core.base.ViewModelKey
import com.example.core.scopes.ActivityScope
import com.rikkei.dynamicfeature.ui.activity.TravelModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class TravelFactoryModelModule {
    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(TravelModel::class)
    protected abstract fun bindTravelActivityViewModel(travelModel: TravelModel): ViewModel

}