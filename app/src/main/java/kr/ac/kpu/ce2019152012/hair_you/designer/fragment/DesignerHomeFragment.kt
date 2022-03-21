package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kpu.ce2019152012.hair_you.adapter.MyRecyclerAdapter
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerHomeBinding
import retrofit2.Retrofit


class DesignerHomeFragment : Fragment() {

    private lateinit var binding: FragmentDesignerHomeBinding
    private lateinit var myReservationAdapter: MyRecyclerAdapter
    private lateinit var myReservationRecyclerView: RecyclerView



    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //myReservationAdapter=view.findViewById(R.layout.recyclerview_current_reservation_item)

        binding = FragmentDesignerHomeBinding.inflate(inflater, container, false)

        myReservationRecyclerView=binding.curReserRcv
        myReservationAdapter=
            MyRecyclerAdapter()


        myReservationRecyclerView.adapter=myReservationAdapter
        myReservationRecyclerView.layoutManager= LinearLayoutManager( getActivity())
        myReservationRecyclerView.layoutManager = LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL,false )
                                                                    // 프래그먼트는 this 대신  getActivity().getApplicationContext() 사용

        binding.refreshFab.setOnClickListener {
            Log.d("event", "refreshFab clicked")
        }

        return binding.root
    }


}