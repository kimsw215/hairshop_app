package com.cookandroid.fill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.cookandroid.fill.Adapter.AdapterMainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureBottomNavigation()
    }


    private fun configureBottomNavigation(){
        xml_main_viewpaper.adapter = AdapterMainFragment(supportFragmentManager,3)
        xml_main_tablayout.setupWithViewPager(xml_main_viewpaper)

        val viewBtmNaviMain : View = this.layoutInflater.inflate(R.layout.btm_navigation_main, null, false)

        xml_main_tablayout.getTabAt(0)!!.customView = viewBtmNaviMain.findViewById(R.id.xml_btmnv_btn_statisticsicon1) as RelativeLayout
        xml_main_tablayout.getTabAt(1)!!.customView = viewBtmNaviMain.findViewById(R.id.xml_btmnv_btn_homeicon1) as RelativeLayout
        xml_main_tablayout.getTabAt(2)!!.customView = viewBtmNaviMain.findViewById(R.id.xml_btmnv_btn_mypageicon1) as RelativeLayout

    }
}