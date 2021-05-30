package com.assignment.bigstepassignment.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.assignment.bigstepassignment.ui.fragment.HistoryFragment
import com.assignment.bigstepassignment.ui.fragment.VideoFragment

class HomeScreenViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val titles: Array<String>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = titles.size

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> VideoFragment()
        1 -> HistoryFragment()
        else -> VideoFragment()
    }
}