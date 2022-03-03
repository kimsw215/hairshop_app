package kr.ac.kpu.ce2019152012.hair_you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityJoinSelectBinding

class JoinSelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinSelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.joinDesignerBtn.setOnClickListener {

        }
    }
}