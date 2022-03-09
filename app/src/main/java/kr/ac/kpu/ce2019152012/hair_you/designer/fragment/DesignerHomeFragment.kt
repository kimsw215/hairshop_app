package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.dto.UserDto
import retrofit2.Retrofit

class DesignerHomeFragment : Fragment() {

    private lateinit var binding: FragmentDesignerHomeBinding

    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = FragmentDesignerHomeBinding.bind(view)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDesignerHomeBinding.inflate(inflater, container, false)


        binding.refreshFab.setOnClickListener {
            Log.d("event", "refreshFab clicked")
        }
        return binding.root
    }


}