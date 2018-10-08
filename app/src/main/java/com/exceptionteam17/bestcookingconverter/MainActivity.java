package com.exceptionteam17.bestcookingconverter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import com.exceptionteam17.bestcookingconverter.fragments.MainFragment;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private AdRequest adRequest;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this, "ca-app-pub-3532736192097860~2266394289");
        adRequest = new AdRequest.Builder().build();
        setContentView(R.layout.activity_main);
        mAdView = findViewById(R.id.adView);
        loadBannerAdd();


        removeActionBar();
        loadFragment(new MainFragment());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.resume();
    }

    @Override
    protected void onPause() {
        mInterstitialAd = new InterstitialAd(this.getApplicationContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3532736192097860/8632808619");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

        mAdView.pause();

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                try{
//                    MainActivity.this.finish();
                    MainActivity.this.moveTaskToBack(true);
                } catch (Exception ignored){}
            }
        });
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mAdView.destroy();
        super.onDestroy();
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

    private void loadBannerAdd() {
        mAdView.loadAd(adRequest);
    }
}
