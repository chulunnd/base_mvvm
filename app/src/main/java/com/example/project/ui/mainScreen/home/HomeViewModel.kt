package com.example.project.ui.mainScreen.home

import com.example.core.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel(){
    init {
        Timber.d("init viewmodel HomeViewModel")
    }
}