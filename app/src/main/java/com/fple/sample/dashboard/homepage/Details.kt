package com.fple.sample.dashboard.homepage

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fple.sample.R


class Details : AppCompatActivity(), View.OnClickListener {

    var txtAppName: TextView? = null
    var txtAppSize: TextView? = null
    var imgAppIcon: ImageView? = null
    var imgAppBanner: ImageView? = null
    var txtRating: TextView? = null
    var txtDescription: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_details)
        SetupViewWay2()
    }

    fun SetupViewWay1() {
        val imgAppIcon: ImageView = findViewById(R.id.imgAppIcon) as ImageView
        val imgAppBanner: ImageView = findViewById(R.id.imgAppBanner) as ImageView
        val imgBack: ImageView = findViewById(R.id.imgBack) as ImageView
        val btnInstall: Button = findViewById(R.id.btnInstall) as Button
        imgBack.setOnClickListener(this)
        btnInstall.setOnClickListener(this)

        val bundle = intent.extras
        if (bundle != null){
            findViewById<TextView>(R.id.txtAppName).apply { text = bundle.getString("appName") }
            findViewById<TextView>(R.id.txtAppSize).apply { text = bundle.getString("appSize") }
            val resID = resources.getIdentifier(bundle.getString("appIcon"), "drawable", packageName)
            imgAppIcon.setImageResource(resID)
            imgAppIcon.background = GetImage(applicationContext, bundle.getString("bgImg"))
            imgAppBanner.setImageResource(resID)
            imgAppBanner.background = GetImage(applicationContext, bundle.getString("bgImg"))
            findViewById<TextView>(R.id.txtRating).apply { text = bundle.getString("rating") }
            findViewById<TextView>(R.id.txtDescription).apply { text = bundle.getString("description") }
        }
    }

    fun SetupViewWay2() {
        val imgBack: ImageView = findViewById(R.id.imgBack) as ImageView
        val btnInstall: Button = findViewById(R.id.btnInstall) as Button
        txtAppName = findViewById(R.id.txtAppName) as TextView
        txtAppSize = findViewById(R.id.txtAppSize) as TextView
        imgAppIcon = findViewById(R.id.imgAppIcon) as ImageView
        imgAppBanner = findViewById(R.id.imgAppBanner) as ImageView
        txtRating = findViewById(R.id.txtRating) as TextView
        txtDescription = findViewById(R.id.txtDescription) as TextView

        imgBack.setOnClickListener(this)
        btnInstall.setOnClickListener(this)

        val bundle = intent.extras
        if (bundle != null){
            txtAppName!!.text = bundle.getString("appName")
            txtAppSize!!.text = bundle.getString("appSize")
            val resID = resources.getIdentifier(bundle.getString("appIcon"), "drawable", packageName)
            imgAppIcon!!.setImageResource(resID)
            imgAppIcon!!.background = GetImage(applicationContext, bundle.getString("bgImg"))
            imgAppBanner!!.setImageResource(resID)
            imgAppBanner!!.background = GetImage(applicationContext, bundle.getString("bgImg"))
            txtRating!!.text = bundle.getString("rating")
            txtDescription!!.text = "Test: ${bundle.getString("description")}"
        }
    }

    override fun onClick(v: View) {
        v.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.button_click))
        when (v.id) {
            R.id.imgBack -> finish() //for fragment => getActivity().onBackPressed();
            R.id.btnInstall -> {}
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun GetImage(c: Context, ImageName: String?): Drawable? {
        return c.getResources()
            .getDrawable(c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName()))
    }
}