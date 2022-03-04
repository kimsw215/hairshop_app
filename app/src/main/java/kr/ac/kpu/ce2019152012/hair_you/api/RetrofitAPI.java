package kr.ac.kpu.ce2019152012.hair_you.api;
import com.google.gson.JsonObject;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

// 데이터를 통신해줄 통로, 인터페이스 객체를 생성
public interface RetrofitAPI {
    @GET("/posts")
    Call<List<POST>> getPosts() ;


}
