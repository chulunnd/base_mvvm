package com.example.project.ui.mainScreen.profile

import com.example.core.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class ProfileViewModel @Inject constructor() : BaseViewModel() {
    init {
        Timber.d("init viewmodel ProfileViewModel")
    }
}