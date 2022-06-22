package kr.ac.kpu.ce2019152012.hair_you.user.fragment

import android.R.attr.data
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.reservation.Reser1


class HomeFragment : Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController : NavController

    // 뷰가 생성되었을 때
    // 프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root

        val extra : Bundle? = arguments
        if (extra != null) {
            var userId = extra.getString("userId")
        }


        var userId : String? = requireActivity().getIntent().getStringExtra("userId")

        /*binding.makeReservationBtn.setOnClickListener {
            val intent= Intent(activity, Reser1::class.java)
            intent.putExtra("shopName","test") // 임시 미용실 이름 : test | 미용실 리스트에서 선택한 값
            intent.putExtra("userId", userId)
            startActivity(intent)
        }*/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}