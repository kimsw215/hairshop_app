package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kr.ac.kpu.ce2019152012.hair_you.R

class DesignerHomeFragment : Fragment() {
    lateinit var reserStatus : TextView
    lateinit var reserManagement : TextView
    lateinit var back_icon : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_designer_home, container, false)



        return view
    }


}