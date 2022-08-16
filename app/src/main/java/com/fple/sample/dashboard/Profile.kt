package com.fple.sample.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import com.fple.sample.R
import com.fple.sample.main.LoginActivity

class Profile : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root = inflater.inflate(R.layout.fragment_profile, container, false)
        var btnLogout = root.findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener{
            startActivity(Intent(activity, LoginActivity::class.java).apply {
                it.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.button_click))
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
        return root
    }
}