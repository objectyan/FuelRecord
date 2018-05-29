package me.objectyan.fuelrecord.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class HomeTabPagerAdapter(fm: FragmentManager?, var list: List<Fragment>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }
}