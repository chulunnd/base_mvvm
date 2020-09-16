package com.rikkei.dynamicfeature.ui.activity

import android.os.Bundle
import androidx.navigation.findNavController
import com.example.core.base.BaseActivity
import com.example.project.Application
import com.example.project.ui.mainScreen.home.di.DaggerTravelActivityComponent
import com.rikkei.dynamicfeature.R
import com.rikkei.dynamicfeature.databinding.ActivityTravelBinding
import com.rikkei.dynamicfeature.navigation.TravelNavigation
import javax.inject.Inject

class TravelActivity : BaseActivity<TravelModel, ActivityTravelBinding>() {

    @Inject
    lateinit var travelNavigation: TravelNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        travelNavigation.bind(findNavController(R.id.nav_travel))
    }

    override fun layoutId() = R.layout.activity_travel

    override fun viewModelClass() = TravelModel::class.java
    override fun injectDependencies() {
        DaggerTravelActivityComponent.builder().appComponent(Application.component).build()
            .inject(this)
    }
}