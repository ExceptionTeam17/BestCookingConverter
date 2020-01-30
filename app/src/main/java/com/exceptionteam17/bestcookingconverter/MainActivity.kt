package com.exceptionteam17.bestcookingconverter

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer
import com.google.android.gms.ads.*
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tabLayout
import kotlinx.android.synthetic.main.activity_main.viewPager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var adRequest: AdRequest? = null
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("bla", "start 11 " + System.currentTimeMillis())
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.IO) {
            loadBannerAdd()
         }
        removeActionBar()
        startTabView()
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

    private suspend fun loadBannerAdd() {
        coroutineScope {
            MobileAds.initialize(this@MainActivity, "ca-app-pub-3532736192097860~2266394289")
            adRequest = AdRequest.Builder().build()
            GlobalScope.launch(Dispatchers.Main) {
                adView.loadAd(adRequest)
            }
        }
    }

    private fun startTabView() {
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.water_drop))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.best_conv_icon))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.wieght_silver))
        tabLayout.addTab(tabLayout.newTab().setText("°C/°F"))
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE)
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout.setScrollPosition(1, 0f, true)
        val adapter = MyPageAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
        try {
            viewPager.setPageTransformer(true, RotateDownTransformer() as ViewPager.PageTransformer)
        } catch (ignored: Exception) { }

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        viewPager.currentItem = 1
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    companion object {
        val buttonClickAnim: AlphaAnimation = AlphaAnimation(2f, 0.7f)
    }
}