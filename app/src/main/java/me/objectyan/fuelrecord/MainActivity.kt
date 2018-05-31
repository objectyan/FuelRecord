package me.objectyan.fuelrecord

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

        }

        supportFragmentManager

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar,R.string.nav_open,R.string.nav_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        listMenu(nav_view.menu.getItem(0))
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // menuInflater.inflate(R.menu.main, menu)
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        listMenu(item)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun listMenu(item: MenuItem) {
        setTitle(item.title)
        when (item.itemId) {
            R.id.nav_menu_home -> {
                setTitle(R.string.app_name)
                val fragment = me.objectyan.fuelrecord.page.home.MainFragment()
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content_frame, fragment)
                fragmentTransaction.commit()
            }
            R.id.nav_menu_timeline -> {
                val fragment = me.objectyan.fuelrecord.page.timeline.MainFragment()
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content_frame, fragment)
                fragmentTransaction.commit()
            }
        }
    }
}
