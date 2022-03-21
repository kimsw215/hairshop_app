package kr.ac.kpu.ce2019152012.hair_you

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.common.util.Utility
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitAPI
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityMainBinding
import kr.ac.kpu.ce2019152012.hair_you.designer.DesignerMainActivity
import kr.ac.kpu.ce2019152012.hair_you.dto.Post
import kr.ac.kpu.ce2019152012.hair_you.user.UserMainActivity
import kr.ac.kpu.ce2019152012.hair_you.user.UserMainActivity.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var retrofit:Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //디자이너 메인 페이지 가는 코드
        binding.gotoDesignerPage.setOnClickListener{
            var intent = Intent(this, DesignerMainActivity::class.java)
            /*
            intent.apply{
                this.putExtra("name", value)
            }
            */




            // 서버 연동 220309
            // 에뮬레이터에서 확인 할 때 10.0.2.2 || 디바이스에서 확인 할 때 실제 내부 ip주소
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val retrofitApi = retrofit.create(RetrofitAPI::class.java)

            // Call -> Call<List<Post>> 반환
            retrofitApi.getData("1").enqueue(object : Callback<List<Post>>{

                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {
                        val data = response.body()
                        Log.d("Network", "onResponse: Succecss")
                        Log.d("Network", "onResponse: "+data!!.get(0).title)

                    }
                }
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Log.d("Network", "onFailure: failed")
                }
            })

            startActivity(intent)
        }


        //유저 메인 페이지 가는 코드
        binding.gotoUserPage.setOnClickListener{
            var intent = Intent(this, UserMainActivity::class.java)
            /*
            intent.apply{
                this.putExtra("name", value)
            }
            */
            startActivity(intent)
        }

        val keyHash = Utility.getKeyHash(this)
        Log.e("해시키", keyHash)
    }



}

