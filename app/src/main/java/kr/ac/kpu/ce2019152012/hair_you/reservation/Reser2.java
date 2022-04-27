package kr.ac.kpu.ce2019152012.hair_you.reservation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;

import kr.ac.kpu.ce2019152012.hair_you.AR.ArMainActivity;
import kr.ac.kpu.ce2019152012.hair_you.R;
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi;
import kr.ac.kpu.ce2019152012.hair_you.api.ReservationApi;
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient;
import kr.ac.kpu.ce2019152012.hair_you.api.ShopApi;
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityReser2Binding;
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto;
import kr.ac.kpu.ce2019152012.hair_you.dto.ReservationDto;
import kr.ac.kpu.ce2019152012.hair_you.dto.ShopDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Reser2 extends AppCompatActivity {
    private ActivityReser2Binding binding;
    private Retrofit rf = RetrofitClient.getClient();

    private ReservationApi reservationApi = rf.create(ReservationApi.class);
    private ShopApi shopApi = rf.create(ShopApi.class);
    private CustomerApi customerApi = rf.create(CustomerApi.class);

    ShopDto shopDto = null;
    CustomerDto customerDto = null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReser2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String shopName = intent.getStringExtra("shopName");
        String userId = intent.getStringExtra("userId");
        Bundle bundle = intent.getExtras();
        LocalDateTime ldt = (LocalDateTime) bundle.get("localdatetime");
        Log.i("reser", "onCreate: @@@@@@@@@@@@" + ldt.toString());

        binding.shopNameTv.setText(shopName);

        Call<ShopDto> shopDtoCall = shopApi.findShopByName(shopName);
        Call<CustomerDto> customerDtoCall = customerApi.findCustomerById(userId);


        try {
            shopDtoCall.enqueue(new Callback<ShopDto>() {
                @Override
                public void onResponse(Call<ShopDto> call, Response<ShopDto> response) {
                    shopDto=response.body();
                }

                @Override
                public void onFailure(Call<ShopDto> call, Throwable t) {

                }
            });
            customerDtoCall.enqueue(new Callback<CustomerDto>() {
                @Override
                public void onResponse(Call<CustomerDto> call, Response<CustomerDto> response) {
                    customerDto=response.body();
                }

                @Override
                public void onFailure(Call<CustomerDto> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        ReservationDto reservationDto = new ReservationDto(" ", " ", ldt, customerDto, shopDto);
        Call<ReservationDto> reservationDtoCall = reservationApi.saveReservation(reservationDto);
        //Log.i("reser", "onCreate: " + customerDto.getName() + "님이 예약되었습니다.");


        View view = (View) findViewById(R.id.select_design);
        ImageView iv=(ImageView) view.findViewById(R.id.hair_design_iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), ArMainActivity.class);
                startActivity(in);
            }
        });

        binding.makeReservationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Reser3.class);
                in.putExtra("shopName", shopName);
                in.putExtra("userId", userId);
                //in.putExtra("cName", customerDto.getName());
                in.putExtra("localdatetime", ldt);



                startActivity(in);
            }
        });
    }
}