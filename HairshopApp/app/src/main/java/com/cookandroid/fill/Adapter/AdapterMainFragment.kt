package com.cookandroid.fill.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cookandroid.fill.Fragment.FragmentMainhome
import com.cookandroid.fill.Fragment.FragmentMainmypage
import com.cookandroid.fill.Fragment.FragmentMainstatics

class AdapterMainFragment(fm: FragmentManager, private val fragmentCount : Int) : FragmentStatePagerAdapter(fm){
    override fun getItem(position : Int) : Fragment{
        return when(position){
            0 -> FragmentMainstatics()
            1 -> FragmentMainhome()
            2 -> FragmentMainmypage()
            else -> FragmentMainstatics()
        }
    }

    override fun getCount(): Int = fragmentCount
}