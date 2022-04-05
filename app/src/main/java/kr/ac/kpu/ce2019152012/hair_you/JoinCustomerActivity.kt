package kr.ac.kpu.ce2019152012.hair_you

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.kakao.sdk.common.util.SdkLogLevel
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityJoinCustomerBinding
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class JoinCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinCustomerBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)
        binding = ActivityJoinCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        Log.d(TAG, "onCreate: " + binding.joinIdEdit.text.toString())
        setup()

        // 회원가입 뒤로가기 버튼
        binding.joinBackBtn.setOnClickListener {
            val intent = Intent(this, JoinSelectActivity::class.java)
            startActivity(intent)
        }

        // 회원가입 버튼 누르면 서버로 Call
        binding.joinInBtn.setOnClickListener {
            val retrofit: Retrofit = RetrofitClient.getClient()
            val customerService: CustomerApi = retrofit.create(CustomerApi::class.java)

            val gender = if (binding.joinSelectMan.isSelected()) "male" else "female"

            val dto = CustomerDto(
                binding.joinNameEdit.text.toString(),
                binding.joinIdEdit.text.toString(),
                binding.joinPwEdit.text.toString(),
                binding.joinPhoneEdit.text.toString(),
                gender
            )

            customerService.saveCustomerInfo(dto).enqueue(object : Callback<CustomerDto> {
                override fun onResponse(call: Call<CustomerDto>, response: Response<CustomerDto>) {
                    Log.d("join", "onResponse: " + response.body()?.name + " 님 회원가입")
                }

                override fun onFailure(call: Call<CustomerDto>, t: Throwable) {
                    Log.d("join", "onFailure: " + t)
                }
            })

            //customer.saveCustomer().enqueue(Callback)

            val email = binding.joinIdEdit.text.toString().trim()
            val password = binding.joinPwEdit.text.toString().trim()

            // Database store
            val userInformation = hashMapOf(
                "id" to binding.joinIdEdit.text.toString().trim(),
                "passwd" to binding.joinPwEdit.text.toString().trim(),
                "name" to binding.joinNameEdit.text.toString().trim(),
                "phone" to binding.joinPhoneEdit.text.toString().trim()
            )

            db.collection("Customer").document("Information")
                .set(userInformation, SetOptions.merge())
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }



            createUser(email, password)
            // 회원가입 완료 후 로그인창으로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            // 이메일 형식 체크
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (task.isSuccessful) {
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            } else {
                Toast.makeText(this, "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "EmailPassword"
    }

    fun setup() {
        db = Firebase.firestore

        val settings = firestoreSettings {
            isPersistenceEnabled = true
        }
        db.firestoreSettings = settings
    }
}
