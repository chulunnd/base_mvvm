package com.rikkei.dynamicfeature.ui.fragment.home

import com.example.core.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class HomeTravelViewModel @Inject constructor() : BaseViewModel() {
    init {
        Timber.d("init viewmodel HomeViewModel")
    }
}