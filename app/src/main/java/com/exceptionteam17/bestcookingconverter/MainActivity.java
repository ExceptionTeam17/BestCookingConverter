package com.exceptionteam17.bestcookingconverter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exceptionteam17.bestcookingconverter.fragments.MainFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        removeActionBar();
        MobileAds.initialize(this, "ca-app-pub-3532736192097860~2266394289");
        loadFragment(new MainFragment());
        mAdView = findViewById(R.id.adView);
        bannerAdd();
    }

    private void removeActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.home_main,fragment);
        ft.commit();
    }

    private void bannerAdd() {
        final AdRequest adRequest = new AdRequest.Builder().build();
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        String s = preferences.getString("firstTimeInstall", "NOO");
//        if (s != null && !s.equals("NOO")) {
            mAdView.loadAd(adRequest);
//        } else {
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putString("firstTimeInstall", "YESS");
//            editor.apply();
//        }
    }
}
