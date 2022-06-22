package kr.ac.kpu.ce2019152012.hair_you.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // AVD에서 접속할 땐 10.0.2.2
    private final static String BASE_URL = "http://15.164.212.9:8080"; // 서버 URL
    private final static String KAKAO_URL="https://dapi.kakao.com/";
    private static Retrofit retrofit = null;

    private RetrofitClient() {
    }

    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getKakao() {
        if (retrofit ==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(KAKAO_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
