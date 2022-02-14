package kr.ac.kpu.ce2019152012.hair_you.designer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerChattingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerHomeFragment
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerSettingFragment


class DesignerMainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var bottomNavigationView : BottomNavigationView
    lateinit var selectedFragment : Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_designer_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)


        bottomNavigationView.setOnItemSelectedListener(this)
        supportFragmentManager.beginTransaction().add(R.id.linearLayout, DesignerHomeFragment()).commit()


        //val keyHash = Utility.getKeyHash(this)
        //Log.e("해시키", keyHash)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.designer_page_home -> {
                //supportFragmentManager.beginTransaction().replace(R.id.linearLayout , DesignerHomeFragment()).commitAllowingStateLoss()
                selectedFragment = DesignerHomeFragment()
                show(selectedFragment)
            }
            R.id.designer_page_chatting -> {
                //supportFragmentManager.beginTransaction().replace(R.id.linearLayout, DesignerChattingFragment()).commitAllowingStateLoss()
                selectedFragment = DesignerChattingFragment()
                show(selectedFragment)
            }
            R.id.designer_page_setting -> {
                //supportFragmentManager.beginTransaction().replace(R.id.linearLayout, DesignerSettingFragment()).commitAllowingStateLoss()
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