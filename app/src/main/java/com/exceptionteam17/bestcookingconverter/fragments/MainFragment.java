package com.exceptionteam17.bestcookingconverter.fragments;

import android.graphics.Color;
import com.google.android.material.tabs.TabLayout;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.exceptionteam17.bestcookingconverter.MyPageAdapter;
import com.exceptionteam17.bestcookingconverter.R;

public final class MainFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        assert inflater != null;
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initialise();
        startTabView();
        return view;
    }

    private void initialise() {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
    }

    private void startTabView() {
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.water_drop));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.best_conv_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.wieght_silver));
        tabLayout.addTab(tabLayout.newTab().setText("°C/°F"));
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setScrollPosition(1,0f,true);

        final MyPageAdapter adapter = new MyPageAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setPageTransformer(true, new RotateDownTransformer());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
