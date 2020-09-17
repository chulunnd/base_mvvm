package com.rikkei.dynamicfeature.ui.fragment.home

import com.example.core.base.BaseFragment
import com.example.project.Application
import com.rikkei.dynamicfeature.R
import com.rikkei.dynamicfeature.databinding.FragmentHomeTravelBinding
import com.rikkei.dynamicfeature.di.component.DaggerHomeTravelComponent
import com.rikkei.dynamicfeature.navigation.TravelNavigation
import com.rikkei.dynamicfeature.ui.activity.TravelActivity
import javax.inject.Inject

class HomeTravelFragment : BaseFragment<HomeTravelViewModel, FragmentHomeTravelBinding>() {

    @Inject
    lateinit var travelNavigation: TravelNavigation

    override fun layoutId(): Int = R.layout.fragment_home_travel

    override fun injectDependencies() {
        if (activity is TravelActivity) {
            DaggerHomeTravelComponent.builder().appComponent(Application.component)
                .travelFactoryViewModelComponent(
                    TravelActivity.componentTravel
                ).build().inject(this)
        }
    }

    override fun viewModelClass(): Class<HomeTravelViewModel> = HomeTravelViewModel::class.java
}