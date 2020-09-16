package com.example.project.navigation

import android.os.Bundle
import com.example.core.navigationComponent.BaseNavigatorImpl

import com.example.recyclerviewmvvm.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigatorImpl @Inject constructor() :
    BaseNavigatorImpl(),
    AppNavigation{

    override fun openSettingScreen(bundle: Bundle?) {
        openScreen(R.id.action_mainFragment_to_settingFragment, bundle)
    }

}