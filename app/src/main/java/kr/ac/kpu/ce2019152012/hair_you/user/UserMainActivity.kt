package kr.ac.kpu.ce2019152012.hair_you.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityUserMainBinding
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.HomeFragment
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.MessageFragment
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.MypageFragment

class UserMainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    lateinit var selectedFragment : Fragment
    private var _binding : ActivityUserMainBinding? =null
    private val binding get() = _binding!!

    //화면이 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUserMainBinding.inflate(layoutInflater)
        // 레이아웃과 연결
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)
        supportFragmentManager.beginTransaction().add(R.id.linearLayout,HomeFragment()).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home->{
                selectedFragment = HomeFragment()
                show(selectedFragment)
            }
            R.id.menu_mypage->{
                selectedFragment = MypageFragment()
                show(selectedFragment)
            }
            R.id.menu_message->{
                selectedFragment = MessageFragment()
                show(selectedFragment)
            }
        }
        return true
    }
    private fun show(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.linearLayout, fragment)
            .commit()
    }
}