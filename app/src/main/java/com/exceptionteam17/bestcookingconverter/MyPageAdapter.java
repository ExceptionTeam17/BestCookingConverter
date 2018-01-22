package com.exceptionteam17.bestcookingconverter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.exceptionteam17.bestcookingconverter.fragments.HardFragment;
import com.exceptionteam17.bestcookingconverter.fragments.LiquidFragment;
import com.exceptionteam17.bestcookingconverter.fragments.MassFragment;


public class MyPageAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;
    private LiquidFragment main0 = new LiquidFragment();
    private MassFragment main = new MassFragment();
    private HardFragment main00 = new HardFragment();

    public MyPageAdapter(FragmentManager fm, int tabs) {
        super(fm);
        if(tabs >= 0) {
            this.numberOfTabs = tabs;
        } else {
            this.numberOfTabs = 0;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
//                LiquidFragment main0 = new LiquidFragment();
                return main0;
            case 1:
//                MassFragment main = new MassFragment();
                return main;
            case 2:
//                HardFragment main00 = new HardFragment();
                return main00;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}