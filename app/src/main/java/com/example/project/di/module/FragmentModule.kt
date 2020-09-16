package com.example.project.di.module

import com.example.project.ui.mainScreen.MainFragment
import com.example.project.ui.mainScreen.home.HomeFragment
import com.example.project.ui.mainScreen.notice.NoticeFragment
import com.example.project.ui.mainScreen.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeNoticeFragment(): NoticeFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

}