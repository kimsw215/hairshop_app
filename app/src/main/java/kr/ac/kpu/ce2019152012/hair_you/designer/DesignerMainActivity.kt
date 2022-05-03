package kr.ac.kpu.ce2019152012.hair_you.designer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityDesignerMainBinding
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerChattingFragment
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerHomeFragment
import kr.ac.kpu.ce2019152012.hair_you.designer.fragment.DesignerSettingFragment


class DesignerMainActivity : AppCompatActivity(){
    private lateinit var binding :ActivityDesignerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostCustomerFragmnet = supportFragmentManager
            .findFragmentById(R.id.DlinearLayout) as NavHostFragment
        val navController = navHostCustomerFragmnet.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    /*
    var fragmentone : Fragmentone = Fragmentone()
    //프래그먼트에 data를 넣어주는 방법
    // 번들을 이용하여 넣어줘야함
    val bundle : Bundle = Bundle()
    bundle.putString("hello","hello")
    fragmentone.arguments = bundle
    */
}