package kr.ac.kpu.ce2019152012.hair_you.reservation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;

import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi;
import kr.ac.kpu.ce2019152012.hair_you.api.ReservationApi;
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient;
import kr.ac.kpu.ce2019152012.hair_you.api.ShopApi;
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityReser3Binding;
import retrofit2.Retrofit;

public class Reser3 extends AppCompatActivity {
    private ActivityReser3Binding binding;
    private Retrofit rf = RetrofitClient.getClient();

    private CustomerApi customerApi = rf.create(CustomerApi.class);
    private ShopApi shopApi = rf.create(ShopApi.class);
    private ReservationApi reservationApi = rf.create(ReservationApi.class);

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityReser3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String shopName=intent.getStringExtra("shopName");
        String userId = intent.getStringExtra("userId");
        String cName = intent.getStringExtra("cName");
        Bundle bundle = intent.getExtras();
        LocalDateTime ldt = (LocalDateTime)bundle.get("localdatetime");

        binding.nameTv.setText(userId+" 님");
        binding.showReserInfoTv.setText(ldt.getMonthValue()+"월    "
                +ldt.getDayOfMonth()+"일    "
                +ldt.getHour()+"시 " );



        binding.backToHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}