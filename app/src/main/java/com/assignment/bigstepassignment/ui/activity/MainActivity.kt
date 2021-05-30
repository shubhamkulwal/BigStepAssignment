package com.assignment.bigstepassignment.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assignment.bigstepassignment.R
import com.assignment.bigstepassignment.ui.adapter.HomeScreenViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val titles = arrayOf("Video", "History")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        view_pager.adapter = HomeScreenViewPagerAdapter(this, titles)
        TabLayoutMediator(tab_layout, view_pager, true) { tab, position -> tab.text = titles[position]}.attach()
    }
}