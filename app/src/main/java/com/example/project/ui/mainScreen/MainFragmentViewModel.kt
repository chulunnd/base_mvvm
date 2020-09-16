package com.example.project.ui.mainScreen

import com.example.core.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor() : BaseViewModel() {
    init {
        Timber.d("init viewmodel MainFragmentViewModel")
    }
}