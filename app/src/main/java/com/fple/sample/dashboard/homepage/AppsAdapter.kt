package com.fple.sample.dashboard.homepage

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fple.sample.R
import com.fple.sample.data.Data

class AppsAdapter(val appsList: ArrayList<Data>): RecyclerView.Adapter<AppsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_appscell, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context: Context = holder.itemView.getContext()
        holder.appsName.text = appsList[position].appName
        holder.appsSize.text = appsList[position].appSize
        val resID = context.resources.getIdentifier(appsList[position].appIcon, "drawable", "com.fple.sample")
        holder.appsIcon.setImageResource(resID)
        holder.bgImg.background = GetImage(context, appsList[position].bgImg)
        holder.btnInstall.setOnClickListener{
            it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.button_click))
            val bundle = Bundle()
            bundle.putString("appName", appsList[position].appName)
            bundle.putString("appSize", appsList[position].appSize)
            bundle.putString("appIcon", appsList[position].appIcon)
            bundle.putString("bgImg", appsList[position].bgImg)
            bundle.putString("rating", appsList[position].rating.toString())
            bundle.putString("description", appsList[position].description)
            bundle.putString("appLabel", appsList[position].appLabel)
            val intent = Intent(context, Details::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = appsList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val appsName: TextView = itemView.findViewById(R.id.txtAppNameFrag)
        val appsSize: TextView = itemView.findViewById(R.id.txtAppSizeFrag)
        val appsIcon: ImageView = itemView.findViewById(R.id.imgAppIconFrag)
        val bgImg: LinearLayout = itemView.findViewById(R.id.bgAppFrag)
        val btnInstall: Button = itemView.findViewById(R.id.btnInstallFrag)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun GetImage(c: Context, ImageName: String?): Drawable? {
        return c.getResources()
            .getDrawable(c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName()))
    }
}