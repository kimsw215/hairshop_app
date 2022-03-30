package kr.ac.kpu.ce2019152012.hair_you

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.ac.kpu.ce2019152012.hair_you.api.DesignerApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityJoinDesignerBinding
import kr.ac.kpu.ce2019152012.hair_you.dto.DesignerDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class JoinDesignerActivity : AppCompatActivity() {

    lateinit var binding: ActivityJoinDesignerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinDesignerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.joinInBtn.setOnClickListener {
            val retrofit: Retrofit = RetrofitClient.getClient()
            val designerService: DesignerApi = retrofit.create(DesignerApi::class.java)

            var gender: String = if (binding.joinFemaleBtn.isSelected()) "female" else "male"

            val dto: DesignerDto = DesignerDto(
                binding.joinNameEdit.text.toString(),
                binding.joinIdEdit.text.toString(),
                binding.joinPwEdit.text.toString(),
                binding.joinPhoneEdit.text.toString(),
                gender,
                binding.joinShopNameEdit.text.toString()
            )

            // POST "/account/designer" dto(body) 요청(call) - > callback으로 DesignerDto 형식으로 반환
            designerService.saveDesignerInfo(dto).enqueue(object : Callback<DesignerDto>  {
                override fun onResponse(call: Call<DesignerDto>, response: Response<DesignerDto>) {
                    Log.d("join", "onResponse: " + response.body()?.name +"님 회원가입" )
                }

                override fun onFailure(call: Call<DesignerDto>, t: Throwable) {
                    Log.d("join", "onFailure: "+ t)
                }

            })
        }

    }
}