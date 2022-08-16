package com.fple.sample.dashboard.homepage

import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fple.sample.R
import com.fple.sample.data.Model
import java.util.*


class Home : Fragment(), Observer, View.OnClickListener {

    var appsModel: Model = Model()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        appsModel.addObserver(this)
        //changeSearchViewTextColor(Searchview)
        //Button1?.setOnClickListener(this)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = AppsAdapter(appsModel.appsList)

        return root
    }

    private fun changeSearchViewTextColor(view: View?) {
        if (view != null) {
            if (view is TextView) {
                view.setTextColor(resources.getColor(R.color.custom_yellow))
                return
            } else if (view is ViewGroup) {
                val viewGroup = view
                for (i in 0 until viewGroup.childCount) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i))
                }
            }
        }
    }

    override fun onClick(v: View) {
        v.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.button_click))
    }

    // function to update the view after the values are modified by the model
    override fun update(arg0: Observable, arg1: Any?) {
        // changing text of the buttons according to updated values
        //Button1!!.text = "Count: " + myModel!!.getValueAtIndex(0)
    }
}
