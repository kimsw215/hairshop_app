package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitAPI
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.dto.UserDto
import kr.ac.kpu.ce2019152012.hair_you.user.UserMainActivity.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import kotlin.math.log

class DesignerHomeFragment : Fragment() {

    private lateinit var binding: FragmentDesignerHomeBinding

    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = FragmentDesignerHomeBinding.bind(view)


        //spring test
        retrofit=Retrofit.Builder()
            .baseUrl("https://59.16.253.112:8080/")    // 우리 집에서 서버 열 때 url 아마도..?
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitApi = retrofit.create(RetrofitAPI ::class.java )
        var call = retrofitApi.getPosts()



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDesignerHomeBinding.inflate(inflater, container, false)

        binding.bellIv.setOnClickListener {
            val dto = UserDto()
            dto.setUserName("tjsal")
            dto.setUserEmail("dfsdf")
            dto.setUserPasswd("qwe123")
        }


        return binding.root
    }


}