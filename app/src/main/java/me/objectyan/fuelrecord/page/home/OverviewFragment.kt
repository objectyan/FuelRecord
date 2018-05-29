package me.objectyan.fuelrecord.page.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.objectyan.fuelrecord.R

class OverviewFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
                R.layout.activity_home_main_overview,
                container,
                false
        )
    }

}