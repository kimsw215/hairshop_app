package kr.ac.kpu.ce2019152012.hair_you.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kr.ac.kpu.ce2019152012.hair_you.R;
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi;
import kr.ac.kpu.ce2019152012.hair_you.api.ReservationApi;
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient;
import kr.ac.kpu.ce2019152012.hair_you.api.ShopApi;
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityReser2Binding;
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityReser3Binding;
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto;
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.HomeFragment;
import retrofit2.Call;
import retrofit2.Retrofit;

public class Reser3 extends AppCompatActivity {
    private ActivityReser3Binding binding;
    private Retrofit rf = RetrofitClient.getClient();

    private CustomerApi customerApi = rf.create(CustomerApi.class);
    private ShopApi shopApi = rf.create(ShopApi.class);
    private ReservationApi reservationApi = rf.create(ReservationApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityReser3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String shopName=intent.getStringExtra("shopName");
        String userId = intent.getStringExtra("userId");
        String dateTime=intent.getStringExtra("dateTime");
        String cName = intent.getStringExtra("cName");



        binding.backToHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}