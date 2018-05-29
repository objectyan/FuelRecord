package me.objectyan.fuelrecord.page.home

import android.os.Bundle;
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.objectyan.fuelrecord.R
import me.objectyan.fuelrecord.R.*
import android.support.v4.view.ViewPager
import android.widget.TableLayout
import me.objectyan.fuelrecord.adapter.HomeTabPagerAdapter


class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
                layout.activity_home_main,
                container,
                false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tab = view.findViewById<TabLayout>(R.id.home_tab)
        val pager = view.findViewById<ViewPager>(R.id.home_viewpager)
        val fragmentList = listOf<Fragment>(OverviewFragment(), CalculatorFragment())
        pager.run {
            adapter = HomeTabPagerAdapter(fragmentManager, fragmentList)
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                }

                override fun onPageSelected(position: Int) {

                }

            })
        }
        tab.run {
            setupWithViewPager(pager)

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

            getTabAt(0)!!.setText(R.string.home_main_tab_overview)
            getTabAt(1)!!.setText(R.string.home_main_tab_calculator)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}