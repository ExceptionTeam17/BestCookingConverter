package com.exceptionteam17.bestcookingconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.exceptionteam17.bestcookingconverter.fragments.MainFragment
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {
    private var mAdView: AdView? = null
    private var adRequest: AdRequest? = null
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this, "ca-app-pub-3532736192097860~2266394289")
        adRequest = AdRequest.Builder().build()
        setContentView(R.layout.activity_main)
        mAdView = findViewById(R.id.adView)
        loadBannerAdd()
        removeActionBar()
        loadFragment(MainFragment())
    }

    override fun onResume() {
        super.onResume()
        mAdView!!.resume()
    }

    override fun onPause() {
        mInterstitialAd = InterstitialAd(this.applicationContext)
        mInterstitialAd!!.adUnitId = "ca-app-pub-3532736192097860/8632808619"
        val interstitialAdRequest = AdRequest.Builder().build()
        mInterstitialAd!!.loadAd(interstitialAdRequest)
        mAdView!!.pause()
        mInterstitialAd!!.adListener = object : AdListener() {
            override fun onAdLoaded() {
                if (mInterstitialAd!!.isLoaded) {
                    mInterstitialAd!!.show()
                }
            }

            override fun onAdClosed() {
                super.onAdClosed()
                try {
                    moveTaskToBack(true)
                } catch (ignored: Exception) { }
            }
        }
        super.onPause()
    }

    override fun onDestroy() {
        mAdView!!.destroy()
        super.onDestroy()
    }

    private fun removeActionBar() {
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.home_main, fragment)
        ft.commit()
    }

    private fun loadBannerAdd() {
        mAdView!!.loadAd(adRequest)
    }
}