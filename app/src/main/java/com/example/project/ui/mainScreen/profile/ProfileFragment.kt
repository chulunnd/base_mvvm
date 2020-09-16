package com.example.project.ui.mainScreen.profile

import com.example.core.base.BaseFragment
import com.example.project.Application
import com.example.project.navigation.AppNavigation
import com.example.project.ui.main.MainActivity
import com.example.project.ui.mainScreen.home.di.DaggerProfileComponent
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {
    override fun layoutId() = R.layout.fragment_profile

    @Inject
    lateinit var appNavigation: AppNavigation

    override fun viewModelClass() = ProfileViewModel::class.java
    override fun injectDependencies() {
        if (activity is MainActivity) {
            DaggerProfileComponent.builder().appComponent(Application.component)
                .factoryViewModelComponent(
                    MainActivity.component
                ).build().inject(this)
        }
    }

}