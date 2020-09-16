package com.example.project.ui.main

import com.example.core.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel(){
    init {
        Timber.d("init viewmodel MainViewModel")
    }
}