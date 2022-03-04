package kr.ac.kpu.ce2019152012.hair_you.retrofit;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private Retrofit retrofitClient = null;

    Retrofit getClient(String baseUrl){

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

