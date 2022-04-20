package kr.ac.kpu.ce2019152012.hair_you.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.NavCustomerMainBinding

class CustomerContainerActivity : AppCompatActivity() {

    private lateinit var binding: NavCustomerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavCustomerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostCustomerFragmnet = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostCustomerFragmnet.navController
        binding.bottomNav.setupWithNavController(navController)
    }
}