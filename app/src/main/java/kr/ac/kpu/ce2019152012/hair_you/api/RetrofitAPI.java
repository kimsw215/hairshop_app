package kr.ac.kpu.ce2019152012.hair_you.api;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.dto.Post;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

// 데이터를 통신해줄 통로, 인터페이스 객체를 생성
public interface RetrofitAPI {
    //Call 객체를 선언해서 HTTP 요청을 웹 서버로 보낸다.
    //JSON 데이터를 <>자료형으로 받겠다.
    @GET("/posts")
    Call<List<Post>> getData(@Query("userId") String userId) ;

    @FormUrlEncoded
    @POST("/posts")
    Call<Post> postData(@FieldMap HashMap<String, Object> param);


}
