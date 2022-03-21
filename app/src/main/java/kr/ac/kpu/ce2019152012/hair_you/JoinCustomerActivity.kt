package kr.ac.kpu.ce2019152012.hair_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityJoinCustomerBinding
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto
import retrofit2.Callback
import retrofit2.Retrofit

class JoinCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinCustomerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinCustomerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 회원가입 뒤로가기 버튼
        binding.joinBackBtn.setOnClickListener {
            var intent = Intent(this,JoinSelectActivity::class.java)
            startActivity(intent)
        }

       // 회원가입 버튼 누르면 서버로 Call
        binding.joinInBtn.setOnClickListener{
            val retrofit : Retrofit = RetrofitClient.getClient()
            val customer : CustomerApi = retrofit.create(CustomerApi::class.java)

            //customer.saveCustomer().enqueue(Callback)

        }
    }
}

//연습