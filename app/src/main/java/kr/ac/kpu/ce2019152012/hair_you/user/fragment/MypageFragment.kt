package kr.ac.kpu.ce2019152012.hair_you.user.fragment

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.kakao.sdk.user.UserApiClient
import kr.ac.kpu.ce2019152012.hair_you.LoginActivity
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentHomeBinding
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentMypageBinding

class MypageFragment : Fragment(){
    //프래그먼트가 메모리에 올라갔을때
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    // 뷰가 생성되었을 때
    // 프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater,container,false)
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        // 프로필 이름
        binding.customerMypageName.setText(" ")
        // Login 에서 currentUser 바꾼 후 변경


        // 프로필 전화 번호
        binding.customerMypagePhone.setText(" ")
        // 이름과 동일일


        // 예약 조회

        // 후기 관리

        // 카카오 로그아웃
        binding.kakaoLogoutbtn.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Toast.makeText(activity, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(activity, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
            }
        }

        // 이메일 로그아웃
        binding.emailLogoutbtn.setOnClickListener {
            Firebase.auth.signOut()
        }

        // 이메일 회원탈퇴
        binding.emailrevoke.setOnClickListener {
            val user = Firebase.auth.currentUser!!

            user.delete()
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Log.d("Revoke","${auth.currentUser.toString()} User account deleted.")
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}