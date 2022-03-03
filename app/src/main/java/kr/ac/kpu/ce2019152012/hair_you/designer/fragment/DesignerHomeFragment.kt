package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentHomeBinding

class DesignerHomeFragment : Fragment() {

    private lateinit var binding: FragmentDesignerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = FragmentDesignerHomeBinding.bind(view)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDesignerHomeBinding.inflate(inflater, container, false)



        return binding.root
    }


}