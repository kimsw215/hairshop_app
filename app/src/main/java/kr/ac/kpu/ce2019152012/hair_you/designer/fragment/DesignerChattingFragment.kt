package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerChattingBinding

class DesignerChattingFragment : Fragment() {

    private lateinit var binding: FragmentDesignerChattingBinding

 

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDesignerChattingBinding.bind(view)
        // Activity의 Oncreate에서 했던 작업을 여기에서 한다



    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




}