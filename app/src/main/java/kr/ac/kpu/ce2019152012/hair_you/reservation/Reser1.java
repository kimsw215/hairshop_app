package kr.ac.kpu.ce2019152012.hair_you.reservation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;

import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient;
import kr.ac.kpu.ce2019152012.hair_you.api.ShopApi;
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityReser1Binding;
import kr.ac.kpu.ce2019152012.hair_you.dto.ShopDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Reser1 extends AppCompatActivity {
    private ActivityReser1Binding binding;

    private Retrofit rf = new Retrofit.Builder()
            .baseUrl("http://59.16.253.112:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private ShopApi shopApi = rf.create(ShopApi.class);
    private ShopDto shopDto = null;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReser1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.selectDateDp.setSpinnersShown(false);

        Intent intent = getIntent();
        String shopName = intent.getStringExtra("shopName");
        String userId = intent.getStringExtra("userId");


        Call<ShopDto> shopDtoCall = shopApi.findShopByName(shopName);
        try {
            shopDtoCall.enqueue(new Callback<ShopDto>() {
                @Override
                public void onResponse(Call<ShopDto> call, Response<ShopDto> response) {
                    shopDto=response.body();
                }

                @Override
                public void onFailure(Call<ShopDto> call, Throwable t) {
                    Log.i("reser", "onFailure: "+t.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        binding.shopNameTv.setText(shopName);



        binding.toSelectDesignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Reser2.class);

                int dateY = binding.selectDateDp.getYear();
                int dateM = binding.selectDateDp.getMonth();
                int dateD = binding.selectDateDp.getDayOfMonth();
                int timeH = binding.selectTimeTp.getHour();

                // 처음 실행했을 때 날짜/시간이 저장돼서 extra로 넘어감
                // 해결해야 함.. LocalDateTime으로 parse해야 됨됨
               Log.i("reser", "onCreate: " + dateY + dateM + dateD);
                String dateTime = String.valueOf(dateY) + "-"+String.valueOf(dateM + 1)+"-" + String.valueOf(dateD)
                        + " " + String.valueOf(timeH);

                in.putExtra("shopName", shopName);
                in.putExtra("userId", userId);
                in.putExtra("dateTime", dateTime);
                startActivity(in);
            }
        });
    }
}