package kr.ac.kpu.ce2019152012.hair_you.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.HomeFragment
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.MessageFragment
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.MypageFragment
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.StarFragment

class UserMainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var homeFragment : HomeFragment
    private lateinit var messageFragment: MessageFragment
    private lateinit var mypageFragment: MypageFragment
    private lateinit var starFragment: StarFragment
    lateinit var bottom_nav : NavigationBarView

    companion object{
        const val TAG: String = "로그"
    }

    //화면이 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 레이아웃과 연결
        setContentView(R.layout.activity_user_main)
        Log.d(TAG,"UserMainActivity - onCreate() called")
        bottom_nav=findViewById(R.id.bottom_nav)

        bottom_nav.setOnItemSelectedListener(this)

        homeFragment= HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "UserMainActivity - onNavigationItemSelected() called")

        when(item.itemId){
            R.id.menu_home->{
                Log.d(TAG, "UserMainActivity - 홈버튼 클릭")
                homeFragment= HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_star->{
                Log.d(TAG, "UserMainActivity - 즐겨찾기 버튼 클릭")
                starFragment= StarFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, starFragment).commit()
            }
            R.id.menu_mypage->{
                Log.d(TAG, "UserMainActivity - 마이페이지 버튼 클릭")
                mypageFragment = MypageFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, mypageFragment).commit()
            }
            R.id.menu_message->{
                Log.d(TAG, "UserMainActivity - 대화방버튼 클릭")
                messageFragment = MessageFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, messageFragment).commit()
            }
        }
        return true
    }
}