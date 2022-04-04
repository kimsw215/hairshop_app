package kr.ac.kpu.ce2019152012.hair_you.designer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityDesignerMainBinding
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerChattingFragment
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerHomeFragment
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerSettingFragment


class DesignerMainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var selectedFragment : Fragment

    private lateinit var binding : ActivityDesignerMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        

        /*
        var fragmentone : Fragmentone = Fragmentone()
        //프래그먼트에 data를 넣어주는 방법
        // 번들을 이용하여 넣어줘야함
        val bundle : Bundle = Bundle()
        bundle.putString("hello","hello")
        fragmentone.arguments = bundle
        */


        binding.bottomNavigationView.setOnItemSelectedListener(this)
       // supportFragmentManager.beginTransaction().add(R.id.linearLayout, DesignerHomeFragment()).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.designer_page_home -> {
                selectedFragment = DesignerHomeFragment()
                show(selectedFragment)
            }
            R.id.designer_page_chatting -> {
                selectedFragment = DesignerChattingFragment()
                show(selectedFragment)
            }
            R.id.designer_page_setting -> {
                selectedFragment = DesignerSettingFragment()
                show(selectedFragment)
            }
        }
        return false
    }

    private fun show(fragment: Fragment) {

        val fragmentManager = supportFragmentManager

        fragmentManager
            .beginTransaction()
            .replace(R.id.linearLayout, fragment)
            .commit()
    }
}