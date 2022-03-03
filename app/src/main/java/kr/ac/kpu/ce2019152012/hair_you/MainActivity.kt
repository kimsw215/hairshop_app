package kr.ac.kpu.ce2019152012.hair_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kakao.sdk.common.util.Utility
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityMainBinding
import kr.ac.kpu.ce2019152012.hair_you.designer.DesignerMainActivity
import kr.ac.kpu.ce2019152012.hair_you.user.UserMainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //디자이너 메인 페이지 가는 코드
        binding.gotoDesignerPage.setOnClickListener{
            var intent = Intent(this, DesignerMainActivity::class.java)
            /*
            intent.apply{
                this.putExtra("name", value)
            }
            */
            startActivity(intent)
        }
        //유저 메인 페이지 가는 코드
        binding.gotoUserPage.setOnClickListener{
            var intent = Intent(this, UserMainActivity::class.java)
            /*
            intent.apply{
                this.putExtra("name", value)
            }
            */
            startActivity(intent)
        }



        val keyHash = Utility.getKeyHash(this)
        Log.e("해시키", keyHash)
    }


}