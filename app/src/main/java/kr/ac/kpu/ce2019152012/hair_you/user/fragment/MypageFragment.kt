package kr.ac.kpu.ce2019152012.hair_you.user.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentMypageBinding

class MypageFragment : Fragment(){
    //프래그먼트가 메모리에 올라갔을때
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.customerMypageName.text = "이름: ${"name"}"
        binding.customerMypagePhone.text = "전화번호: ${"phone"}"

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