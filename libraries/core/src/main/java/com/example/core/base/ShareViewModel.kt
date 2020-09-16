package com.example.core.base

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

//this model to share data between fragments - require container activity
class ShareViewModel @Inject constructor() : BaseViewModel(){
    val userType = MutableLiveData<String>(null)
}