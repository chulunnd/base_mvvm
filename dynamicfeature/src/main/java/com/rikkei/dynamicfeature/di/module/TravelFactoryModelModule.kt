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

@Module
abstract class TravelFactoryModelModule {
    @ActivityScope
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(TravelModel::class)
    protected abstract fun bindTravelActivityViewModel(travelModel: TravelModel): ViewModel

}