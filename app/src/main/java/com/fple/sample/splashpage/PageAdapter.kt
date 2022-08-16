package com.fple.sample.splashpage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount() = 4

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> { return Splash1() }
            1 -> { return Splash2() }
            2 -> { return Splash3() }
            3 -> { return Splash4() }
            else -> { return Splash1() }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> { return "Page 1" }
            1 -> { return "Page 2" }
            2 -> { return "Page 3" }
            3 -> { return "Page 4" }
        }
        return super.getPageTitle(position)
    }

//    override fun getPageTitle(position: Int) = when (position) {
//        0 -> "One"
//        1 -> "Two"
//        2 -> "Three"
//        3 -> "Four"
//        else -> "One"
//    }
}