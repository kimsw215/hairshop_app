package kr.ac.kpu.ce2019152012.hair_you.user.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.ac.kpu.ce2019152012.hair_you.R

class MessageFragment : Fragment(){

    companion object {
        const val TAG : String ="로그"

        fun newInstance() : MessageFragment {
            return MessageFragment()
        }
    }

    //프래그먼트가 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MessageFragment - onCreate() called")
    }

    //프래그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    // 뷰가 생성되었을 때
    // 프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG,"MessageFragment - onCreateView() called")

        val view = inflater.inflate(R.layout.fragment_message, container, false)

        return view
    }
}