package com.exceptionteam17.bestcookingconverter

import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import com.exceptionteam17.bestcookingconverter.fragments.MainFragment
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var adRequest: AdRequest? = null
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("bla", "start 11 " + System.currentTimeMillis())
        GlobalScope.launch(Dispatchers.Main) {
            loadBannerAdd()
        }
        setContentView(R.layout.activity_main)
        removeActionBar()
        loadFragment()
    }

    override fun onResume() {
        super.onResume()
        adView.resume()
        Log.e("bla", "7 " + System.currentTimeMillis())
    }

    override fun onPause() {
        mInterstitialAd = InterstitialAd(this.applicationContext)
        mInterstitialAd!!.adUnitId = "ca-app-pub-3532736192097860/8632808619"
        val interstitialAdRequest = AdRequest.Builder().build()
        mInterstitialAd!!.loadAd(interstitialAdRequest)
        adView.pause()
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
        adView.destroy()
        super.onDestroy()
    }

    private fun removeActionBar() {
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }

    private fun loadFragment() {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.home_main, MainFragment())
        ft.commit()
    }

    private fun loadBannerAdd() {
        MobileAds.initialize(this@MainActivity, "ca-app-pub-3532736192097860~2266394289")
        adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    companion object {
        val buttonClickAnim: AlphaAnimation = AlphaAnimation(2f, 0.7f)
    }
}