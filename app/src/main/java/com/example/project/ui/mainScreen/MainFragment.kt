package com.example.project.ui.mainScreen

import android.os.Bundle
import android.view.View
import com.example.core.base.SaveViewBaseFragment
import com.example.project.Application
import com.example.project.adapter.MainPagerAdapter
import com.example.project.adapter.NUMBER_PAGE
import com.example.project.navigation.AppNavigation
import com.example.project.ui.main.MainActivity
import com.example.project.ui.mainScreen.home.di.DaggerMainComponent
import com.example.project.ui.mainScreen.home.di.DaggerProfileComponent
import com.example.project.ui.mainScreen.home.di.MainComponent
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : SaveViewBaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    @Inject
    lateinit var appNavigation: AppNavigation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (binding.viewPager.adapter == null) {
            binding.viewPager.apply {
                adapter = MainPagerAdapter(childFragmentManager)
                if (savedInstanceState == null) {
                    offscreenPageLimit = NUMBER_PAGE - 1
                }
            }
        }

        binding.bottomView.setOnNavigationItemSelectedListener {
            val position = when (it.itemId) {
                R.id.btnHome -> MainPagerAdapter.INDEX_HOME_SCREEN
                R.id.btnNotice -> MainPagerAdapter.INDEX_NOTICE_SCREEN
                R.id.btnProfile -> MainPagerAdapter.INDEX_PROFILE_SCREEN
                else -> MainPagerAdapter.INDEX_HOME_SCREEN
            }
            binding.viewPager.setCurrentItem(position, false)
            true
        }


    }

    override fun layoutId() = R.layout.fragment_main

    override fun viewModelClass() = MainFragmentViewModel::class.java
    override fun injectDependencies() {
        if (activity is MainActivity) {
            DaggerMainComponent.builder().appComponent(Application.component)
                .factoryViewModelComponent(
                    MainActivity.component
                ).build().inject(this)
        }
    }

}