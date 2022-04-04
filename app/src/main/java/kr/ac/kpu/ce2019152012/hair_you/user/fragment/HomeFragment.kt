package kr.ac.kpu.ce2019152012.hair_you.user.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.ac.kpu.ce2019152012.hair_you.adapter.RecyclerShopAdapter
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.user.UserMainActivity
import kr.ac.kpu.ce2019152012.hair_you.user.model.ShopModel

class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerShopAdapter: RecyclerShopAdapter
    //private lateinit var shopRecyclerView: RecyclerView
    val datas = mutableListOf<ShopModel>()


    private val shopList = mutableListOf<ShopModel>()

    // 뷰가 생성되었을 때
    // 프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        initRecycler()
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler() {
        recyclerShopAdapter = RecyclerShopAdapter(requireContext())
        binding.recyclerview.adapter = recyclerShopAdapter


        datas.apply {
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "헤어 살롱", location = "파주"))
            add(ShopModel(shopname = "마헤어", location = "인천"))
            add(ShopModel(shopname = "박준헤어", location = "서울"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))
            add(ShopModel(shopname = "마끼다헤어", location = "안양"))




            recyclerShopAdapter.datas = datas
            recyclerShopAdapter.notifyDataSetChanged()

        }
    }


    private val auth: FirebaseAuth by lazy {
        Firebase.auth
    }

}