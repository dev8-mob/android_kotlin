package com.fple.sample.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.fple.sample.R
import com.google.android.material.tabs.TabLayout

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_dashboard)
        val tabs = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        viewPager.adapter = PageAdapter(supportFragmentManager)
        viewPager.offscreenPageLimit = 4
        tabs.setupWithViewPager(viewPager)
        for (i in 0 until tabs.getTabCount()) {
            when(i) {
                0 -> { tabs.getTabAt(i)?.setIcon(R.drawable.tab_home) }
                1 -> { tabs.getTabAt(i)?.setIcon(R.drawable.tab_website) }
                2 -> { tabs.getTabAt(i)?.setIcon(R.drawable.tab_discover) }
                3 -> { tabs.getTabAt(i)?.setIcon(R.drawable.tab_profile) }
            }
            //val id = resources.getIdentifier("resourceName", "drawable", packageName)
            //imageView.setImageResource(id)
        }
    }
}