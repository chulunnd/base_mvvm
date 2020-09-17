package com.rikkei.dynamicfeature.ui.activity

import android.os.Bundle
import androidx.navigation.findNavController
import com.example.core.base.BaseActivity
import com.example.core.utils.Defines
import com.example.project.Application
import com.example.project.ui.mainScreen.home.di.DaggerTravelActivityComponent
import com.rikkei.dynamicfeature.R
import com.rikkei.dynamicfeature.databinding.ActivityTravelBinding
import com.rikkei.dynamicfeature.di.component.DaggerTravelFactoryViewModelComponent
import com.rikkei.dynamicfeature.di.component.TravelFactoryViewModelComponent
import com.rikkei.dynamicfeature.navigation.TravelNavigation
import javax.inject.Inject

class TravelActivity : BaseActivity<TravelModel, ActivityTravelBinding>() {

    @Inject
    lateinit var travelNavigation: TravelNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navicontrol = findNavController(R.id.nav_travel)
        val bundle = Bundle()
        bundle.putString(Defines.HELLO, "hello travel")
        navicontrol.setGraph(navicontrol.graph, bundle)
        travelNavigation.bind(navicontrol)

    }

    override fun layoutId() = R.layout.activity_travel

    override fun viewModelClass() = TravelModel::class.java


    override fun injectDependencies() {
        componentTravel = DaggerTravelFactoryViewModelComponent.builder().build();
        DaggerTravelActivityComponent.builder()
            .appComponent(Application.component)
            .travelFactoryViewModelComponent(
                componentTravel
            ).build()
            .inject(this)
    }

    companion object {
        lateinit var componentTravel: TravelFactoryViewModelComponent
    }
}