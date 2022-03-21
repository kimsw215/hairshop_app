package kr.ac.kpu.ce2019152012.hair_you

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityJoinCustomerBinding
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class JoinCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinCustomerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 회원가입 뒤로가기 버튼
        binding.joinBackBtn.setOnClickListener {
            var intent = Intent(this, JoinSelectActivity::class.java)
            startActivity(intent)
        }


        //binding.joinFemaleBtn.setSelected(!(binding.joinMaleBtn.isSelected()))

        var gender: String = if (binding.joinMaleBtn.isSelected()) "male" else "female"

        // 회원가입 버튼 누르면 서버로 Call
        binding.joinInBtn.setOnClickListener {
            val retrofit: Retrofit = RetrofitClient.getClient()
            val customer: CustomerApi = retrofit.create(CustomerApi::class.java)


            val dto: CustomerDto = CustomerDto(
                binding.joinNameEdit.toString(),
                binding.joinIdEdit.toString(),
                binding.joinPwEdit1.toString(),
                binding.joinPhoneEdit.toString(),
                gender
            )


            customer.saveCustomer(dto).enqueue(object : Callback<CustomerDto> {
                override fun onResponse(call: Call<CustomerDto>, response: Response<CustomerDto>) {
                    Log.d("join", "onResponse: successed" + response.body())
                }

                override fun onFailure(call: Call<CustomerDto>, t: Throwable) {
                    Log.d("join", "onFailure: failed" + t)
                }
            })

        }
    }
}

//연습