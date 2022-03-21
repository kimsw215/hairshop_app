package kr.ac.kpu.ce2019152012.hair_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityJoinSelectBinding
import kr.ac.kpu.ce2019152012.hair_you.designer.DesignerMainActivity

class JoinSelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinSelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.joinDesignerBtn.setOnClickListener {
            var intent = Intent(this, JoinDesignerActivity::class.java)
            startActivity(intent)
        }
        binding.joinCustomerBtn.setOnClickListener{
            var intent = Intent(this, JoinCustomerActivity::class.java)
            startActivity(intent)
        }
    }
}