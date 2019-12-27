package com.exceptionteam17.bestcookingconverter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.exceptionteam17.bestcookingconverter.fragments.HardFragment
import com.exceptionteam17.bestcookingconverter.fragments.LiquidFragment
import com.exceptionteam17.bestcookingconverter.fragments.MassFragment
import com.exceptionteam17.bestcookingconverter.fragments.TempFragment

class MyPageAdapter(fm: FragmentManager?, tabs: Int) : FragmentPagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val numberOfTabs = if (tabs >= 0) { tabs } else { 0 }
    private val liquidFragment = LiquidFragment()
    private val mainMassFragment = MassFragment()
    private val hardFragment = HardFragment()
    private val tempFragment = TempFragment()

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> liquidFragment
            1 -> mainMassFragment
            2 -> hardFragment
            3 -> tempFragment
            else -> mainMassFragment
        }
    }

    override fun getCount(): Int {
        return numberOfTabs
    }
}