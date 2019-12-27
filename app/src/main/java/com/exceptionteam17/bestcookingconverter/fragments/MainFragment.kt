package com.exceptionteam17.bestcookingconverter.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.PageTransformer
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer
import com.exceptionteam17.bestcookingconverter.MyPageAdapter
import com.exceptionteam17.bestcookingconverter.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainFragment : Fragment() {
    private var myView: View? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_main, container, false)
        initialise()
        startTabView()
        return myView
    }

    private fun initialise() {
        tabLayout = myView!!.findViewById(R.id.tabLayout)
        viewPager = myView!!.findViewById(R.id.viewPager)
    }

    private fun startTabView() {
        tabLayout!!.addTab(tabLayout!!.newTab().setIcon(R.drawable.water_drop))
        tabLayout!!.addTab(tabLayout!!.newTab().setIcon(R.drawable.best_conv_icon))
        tabLayout!!.addTab(tabLayout!!.newTab().setIcon(R.drawable.wieght_silver))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("°C/°F"))
        tabLayout!!.setTabTextColors(Color.WHITE, Color.WHITE)
        tabLayout!!.setSelectedTabIndicatorColor(Color.WHITE)
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout!!.setScrollPosition(1, 0f, true)
        val adapter = MyPageAdapter(childFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter
        viewPager!!.offscreenPageLimit = 2
        try {
            viewPager!!.setPageTransformer(true, RotateDownTransformer() as PageTransformer)
        } catch (ignored: Exception) { }

        viewPager!!.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        viewPager!!.currentItem = 1
        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}