package kr.ac.kpu.ce2019152012.hair_you.retrofit;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class RetrofitClient {

    private Retrofit retrofitClient = null;

    public Retrofit getClient(String baseUrl){
        Log.d(TAG, "onCreate: retrofit");

        if(retrofitClient == null){
            // 레트로핏 빌더를 통해 인스턴스 생성
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofitClient;
    }
}

