package com.fple.sample.splashpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import com.fple.sample.main.LoginActivity
import com.fple.sample.R

class Splash4 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_splash4, container, false)
        val btnStart = root.findViewById<Button>(R.id.btn_getstart)
        btnStart.setOnClickListener{
            it.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.button_click))
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        return root
    }
}