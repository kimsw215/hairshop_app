package kr.ac.kpu.ce2019152012.hair_you.api;

import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.dto.ReservationDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReservationApi {
    @GET("/reservations")
    Call<List<ReservationDto>> findAllReservations();

    @GET("/account/id/{id}/reservations")
    Call<List<ReservationDto>> findByCustomerId(@Path("id") String id);

    @GET("/shop/name/{name}/reservations")
    Call<List<ReservationDto>> findByShopName(@Path("name") String shopname);

    @POST("/reservation")
    Call<ReservationDto> saveReservation(@Body ReservationDto dto);


}
