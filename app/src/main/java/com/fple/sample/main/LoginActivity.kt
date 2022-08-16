package com.fple.sample.main

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fple.sample.R
import com.fple.sample.dashboard.Dashboard

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener{
            startActivity(Intent(this, Dashboard::class.java).apply {
                it.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.button_click))
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
    }
}