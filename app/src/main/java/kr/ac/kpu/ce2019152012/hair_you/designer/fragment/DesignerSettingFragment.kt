package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerSettingBinding

class DesignerSettingFragment : Fragment() {
    private lateinit var binding : FragmentDesignerSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = FragmentDesignerSettingBinding.bind(view)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDesignerSettingBinding.inflate(inflater, container, false)

        return binding.root
    }


}