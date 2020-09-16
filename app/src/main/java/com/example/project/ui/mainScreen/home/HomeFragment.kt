package com.example.project.ui.mainScreen.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.core.base.BaseFragment
import com.example.project.Application
import com.example.project.navigation.AppNavigation
import com.example.project.ui.mainScreen.home.di.DaggerHomeComponent
import com.example.project.ui.mainScreen.home.di.DaggerMainComponent
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    @Inject
    lateinit var appNavigation: AppNavigation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.background.setOnClickListener {
//            appNavigation.openSettingScreen()
            var intent = Intent(Intent.ACTION_VIEW).setClassName(
                "com.example.recyclerviewmvvm",
                "com.rikkei.dynamicfeature.ui.activity.TravelActivity"
            )
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

    }

    override fun layoutId() = R.layout.fragment_home

    override fun viewModelClass() = HomeViewModel::class.java
    override fun injectDependencies() {
        DaggerHomeComponent.builder().appComponent(Application.component).build().inject(this)
    }
}