package com.fple.sample.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.afollestad.viewpagerdots.DotsIndicator
import com.fple.sample.R
import com.fple.sample.splashpage.PageAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val dots: DotsIndicator = findViewById(R.id.indicator)
        viewPager.adapter = PageAdapter(supportFragmentManager)
        viewPager.offscreenPageLimit = 4
        dots.attachViewPager(viewPager)
        dots.setDotTintRes(R.color.white)

        //viewPager.adapter = PagerAdapter()
        //val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        //tabLayout.setupWithViewPager(viewPager)
    }
}