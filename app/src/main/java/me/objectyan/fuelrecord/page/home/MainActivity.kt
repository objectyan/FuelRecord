package me.objectyan.fuelrecord.page.home

import android.os.Bundle;
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem
import android.view.View;
import android.view.ViewGroup;
import me.objectyan.fuelrecord.R.*


class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
                layout.activity_home_main,
                container,
                false
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}