package com.example.project.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.project.ui.mainScreen.home.HomeFragment
import com.example.project.ui.mainScreen.notice.NoticeFragment
import com.example.project.ui.mainScreen.profile.ProfileFragment

public const val NUMBER_PAGE = 3

class MainPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        const val INDEX_HOME_SCREEN = 0
        const val INDEX_NOTICE_SCREEN = 1
        const val INDEX_PROFILE_SCREEN = 2
    }

    override fun getItem(position: Int) = when (position) {
        INDEX_HOME_SCREEN -> HomeFragment()
        INDEX_NOTICE_SCREEN -> NoticeFragment()
        INDEX_PROFILE_SCREEN -> ProfileFragment()
        else -> HomeFragment()
    }

    override fun getCount() = NUMBER_PAGE
}