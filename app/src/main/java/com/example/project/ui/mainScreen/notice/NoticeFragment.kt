package com.example.project.ui.mainScreen.notice

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.core.base.BaseFragment
import com.example.project.Application
import com.example.project.navigation.AppNavigation
import com.example.project.ui.mainScreen.home.di.DaggerHomeComponent
import com.example.project.ui.mainScreen.home.di.DaggerNoticeComponent
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.databinding.FragmentNoticeBinding
import javax.inject.Inject

class NoticeFragment : BaseFragment<NoticeViewModel, FragmentNoticeBinding>() {

    @Inject
    lateinit var appNavigation: AppNavigation

    override fun layoutId() = R.layout.fragment_notice

    override fun viewModelClass() = NoticeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun injectDependencies() {
        DaggerNoticeComponent.builder().appComponent(Application.component).build().inject(this)
    }
}