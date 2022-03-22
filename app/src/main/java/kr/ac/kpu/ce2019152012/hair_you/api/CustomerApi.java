package kr.ac.kpu.ce2019152012.hair_you.api;

import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CustomerApi {
    @POST("/account/customer")
    Call<CustomerDto> saveCustomer(@Body CustomerDto jsonparams);
}
