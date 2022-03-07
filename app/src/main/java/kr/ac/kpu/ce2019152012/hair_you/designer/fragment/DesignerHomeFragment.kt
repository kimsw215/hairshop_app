package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.adapter.MyReservationRecyclerAdapter
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.item.tmpItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DesignerHomeFragment : Fragment() {

    private lateinit var binding: FragmentDesignerHomeBinding
    private lateinit var myReservationAdapter: MyReservationRecyclerAdapter
    private lateinit var myReservationRecyclerView: RecyclerView
    private lateinit var tmpItems : ArrayList<tmpItem>

    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //binding = FragmentDesignerHomeBinding.bind(view)


        /*
        //spring test
        retrofit=Retrofit.Builder()
            .baseUrl("https://59.16.253.112:8080/")    // 우리 집에서 서버 열 때 url 아마도..?
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitApi = retrofit.create(RetrofitAPI ::class.java )
        var call = retrofitApi.getPosts()
        */


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //myReservationAdapter=view.findViewById(R.layout.recyclerview_current_reservation_item)

        binding = FragmentDesignerHomeBinding.inflate(inflater, container, false)

        myReservationRecyclerView=binding.curReserRcv
        myReservationAdapter=MyReservationRecyclerAdapter()


        myReservationRecyclerView.adapter=myReservationAdapter
        myReservationRecyclerView.layoutManager= LinearLayoutManager( getActivity())
        myReservationRecyclerView.layoutManager = LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL,false )
                                                                    // 프래그먼트는 this 대신  getActivity().getApplicationContext() 사용

        // 리사이클러뷰 예시
        tmpItems=ArrayList<tmpItem>();
        tmpItems.add(tmpItem("홍길동","22-03-01","펌","010-1234-1234"))
        tmpItems.add(tmpItem("김수한","22-03-02","펌","010-7777-7777"))
        tmpItems.add(tmpItem("이순신","22-03-03","펌","010-0000-1234"))
        myReservationAdapter.setList(tmpItems)
        myReservationAdapter.notifyDataSetChanged()

        return binding.root
    }


}