package com.example.project.navigation

import android.os.Bundle
import com.example.core.navigationComponent.BaseNavigator

interface AppNavigation : BaseNavigator {
    fun openSettingScreen(bundle: Bundle? = null)
}