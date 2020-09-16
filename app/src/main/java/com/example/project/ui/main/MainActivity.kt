package com.example.project.ui.main

import android.os.Bundle
import androidx.navigation.findNavController
import com.example.core.base.BaseActivity
import com.example.project.Application
import com.example.project.navigation.AppNavigation
import com.example.project.ui.main.di.DaggerMainActivityComponent
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    @Inject
    lateinit var appNavigation: AppNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appNavigation.bind(findNavController(R.id.nav_host))
    }

    override fun layoutId() = R.layout.activity_main

    override fun viewModelClass() = MainViewModel::class.java
    override fun injectDependencies() {
        DaggerMainActivityComponent.builder().appComponent(Application.component).build().inject(this)
    }

}