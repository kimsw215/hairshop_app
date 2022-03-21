package kr.ac.kpu.ce2019152012.hair_you

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityJoinCustomerBinding
import retrofit2.Retrofit

class JoinCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinCustomerBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinCustomerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        // 회원가입 뒤로가기 버튼
        binding.joinBackBtn.setOnClickListener {
            var intent = Intent(this, JoinSelectActivity::class.java)
            startActivity(intent)
        }

        // 회원가입 버튼 누르면 서버로 Call
        binding.joinInBtn.setOnClickListener {
            val retrofit: Retrofit = RetrofitClient.getClient()
            val customer: CustomerApi = retrofit.create(CustomerApi::class.java)
            //customer.saveCustomer().enqueue(Callback)

            // 이메일로 회원가입 회원가입 후 firebase로 데이터 전송

            var userDto = UserDto()
            userDto.identification = auth?.currentUser?.uid
            userDto.id = binding.joinIdEdit.text.toString().trim()
            userDto.passwd = binding.joinPwEdit.text.toString().trim()
            userDto.name = binding.joinNameEdit.text.toString().trim()
            userDto.phone = binding.joinPhoneEdit.text.toString().trim()
            // 이건 userDto 클래스를 통채로 파베에 uid 순으로 넣는 것
            firestore?.collection(auth!!.currentUser!!.uid)?.document()?.set(userDto)

            val email = binding.joinIdEdit.text.toString().trim()
            val password = binding.joinPwEdit.text.toString().trim()
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                // 이메일 형식 체크
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (task.isSuccessful) {
                        firestore?.collection(auth!!.currentUser!!.uid)?.document()?.set(userDto)
                        Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show()
                }
            }


            // 함수형으로 쓸지 그냥 클릭리스너 안에 넣을지 고민
            // 고민하는 이유 -> 함수로 만들어서 보내면 id,pw 외에 부가적인 정보를 넣기 어려움
            // 그냥 클릭리스너안에 넣으면 위에 처럼 넣어지는 듯 실험해봐야함


            //createUser(email,password)

            // 회원가입 완료 후 로그인창으로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->

            // 이메일 형식 체크
            if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                if (task.isSuccessful) {
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                } else {
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

// firebase에 정보를 담기위한 데이터 클래스
data class UserDto(
    var identification: String? = null,
    var name: String? = null,
    var id: String? = null,
    var passwd: String? = null,
    var phone: String? = null
    //var gender: String? = null,
)

//연습