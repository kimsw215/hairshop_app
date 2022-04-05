package kr.ac.kpu.ce2019152012.hair_you.api;

import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.dto.ReviewDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReviewApi {
    @GET("/reviews")
    Call<List<ReviewDto>> findAllReviews();

    @GET("/account/{c_id}/reviews")
    Call<List<ReviewDto>> findAllReviewsByCId(@Path("c_id") String c_id);

    @POST("/review")
    Call<ReviewDto> saveReview(@Body ReviewDto dto);
}
