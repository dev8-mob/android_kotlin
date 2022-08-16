package com.fple.sample.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fple.sample.dashboard.homepage.*

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount() = 4

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> { return Home() }
            1 -> { return Website() }
            2 -> { return Discover() }
            3 -> { return Profile() }
            else -> { return Home() }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> { return "Home" }
            1 -> { return "Website" }
            2 -> { return "Discover" }
            3 -> { return "Profile" }
        }
        return super.getPageTitle(position)
    }
}