package com.example.project.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.base.ViewModelFactory
import com.example.core.base.ViewModelKey
import com.example.core.scopes.ActivityScope
import com.example.project.ui.main.MainViewModel
import com.example.project.ui.mainScreen.MainFragmentViewModel
import com.example.project.ui.mainScreen.home.HomeViewModel
import com.example.project.ui.mainScreen.notice.NoticeViewModel
import com.example.project.ui.mainScreen.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FactoryModelModule {
    @ActivityScope
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun bindMainModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    protected abstract fun bindMainFragmentViewModel(mainFragmentViewModel: MainFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    protected abstract fun bindHomeViewModel(incomingViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NoticeViewModel::class)
    protected abstract fun bindNoticeViewModel(videoCallViewModel: NoticeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    protected abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

}