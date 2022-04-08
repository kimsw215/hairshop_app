package kr.ac.kpu.ce2019152012.hair_you.designer.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kpu.ce2019152012.hair_you.adapter.MyChattingRecyclerviewAdapter
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentDesignerChattingBinding

class DesignerChattingFragment : Fragment() {

    private var _binding: FragmentDesignerChattingBinding? = null
    private val binding get() = _binding!!
    /*private lateinit var mAdapter : MyChattingRecyclerviewAdapter
    private lateinit var mChatRecyclerView: RecyclerView*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDesignerChattingBinding.inflate(inflater, container, false)

/*        mChatRecyclerView=binding.chattingRcv
        mAdapter= MyChattingRecyclerviewAdapter()

        mChatRecyclerView.adapter=mAdapter
        mChatRecyclerView.layoutManager=LinearLayoutManager(getActivity())
        mChatRecyclerView.layoutManager=LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false)*/


        val view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}