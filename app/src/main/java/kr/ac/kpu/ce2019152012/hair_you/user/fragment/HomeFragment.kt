package kr.ac.kpu.ce2019152012.hair_you.user.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.common.collect.Collections2.filter
import com.google.common.collect.Multisets.filter
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.adapter.SearchAdapter
import kr.ac.kpu.ce2019152012.hair_you.api.KakaoApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.dto.SearchDataVo
import retrofit2.Retrofit
import java.util.Locale.filter


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val rf2: Retrofit = RetrofitClient.getKakao()
    val kakaoApi = rf2.create(KakaoApi::class.java)
    val KAKAO_API_KEY = "KakaoAK 6c15981489ac8f7193df22c979df29f2"

    var place_name: String = "@@@@@@@@@@@@@"             // 장소명, 업체명
    lateinit var address_name: String           // 전체 지번 주소
    lateinit var road_address_name: String      // 전체 도로명 주소
    lateinit var x: String                      // X 좌표값 혹은 longitude
    lateinit var y: String                      // Y 좌표값 혹은 latitude

    val call = kakaoApi.getSearchKeyword(KAKAO_API_KEY, "미용실", "126.733627", "37.3400927", 20000)
    var listOfPlace = call.execute().body()!!.documents

    // Adapter 변수 선언
    private lateinit var listAdapter: SearchAdapter

    // linearManager
    private lateinit var Lmanager: LinearLayoutManager

    // 검색 정보 변수 선언
    private lateinit var datas: ArrayList<SearchDataVo>

    private lateinit var navController: NavController

    // 뷰가 생성되었을 때
    // 프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

/*        val extra : Bundle? = arguments
        if (extra != null) {
            var userId = extra.getString("userId")
        }


        var userId : String? = requireActivity().getIntent().getStringExtra("userId")

        binding.makeReservationBtn.setOnClickListener {
            val intent= Intent(activity, Reser1::class.java)
            intent.putExtra("shopName","test") // 임시 미용실 이름 : test | 미용실 리스트에서 선택한 값
            intent.putExtra("userId", userId)
            startActivity(intent)
        }*/

        binding.rvSearchView.setOnQueryTextListener(searchViewTextListener)

        datas = tempData()
        setAdapter()

        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)
        val navHostUserFragment = requireActivity().supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostUserFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        return view
    }

    var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            // 검색버튼 입력 시 호출, 검색 버튼이 없으므로 사용하지 않음
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            // 텍스트 입력/수정시에 호출
            override fun onQueryTextChange(p0: String?): Boolean {
                listAdapter.filter.filter(p0)
                return false
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // 어댑터 부착
    private fun setAdapter() {
        listAdapter = SearchAdapter(datas)
        Lmanager = LinearLayoutManager(requireContext())

        binding.rvShoplist.apply {
            layoutManager = Lmanager
            adapter = listAdapter
            setHasFixedSize(true)
        }
    }

    fun tempData(): ArrayList<SearchDataVo> {
        var tempData = ArrayList<SearchDataVo>()

        for (i in 1..14) {
            tempData.add(
                SearchDataVo(
                    listOfPlace[i].place_name,
                    listOfPlace[i].address_name,
                    listOfPlace[i].road_address_name
                )
            )
        }
        return tempData
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
