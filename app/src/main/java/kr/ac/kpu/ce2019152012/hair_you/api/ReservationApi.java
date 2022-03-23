package kr.ac.kpu.ce2019152012.hair_you.api;

import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.dto.ReservationDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReservationApi {
    @GET("/reservation")
    Call<List<ReservationDto>> indexReservations();

    @POST("/reservation")
    Call<ReservationDto> saveReservation(@Body ReservationDto dto);

}
