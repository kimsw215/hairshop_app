package kr.ac.kpu.ce2019152012.hair_you.api;

import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CustomerApi {
    @POST("/account/customer")
    Call<CustomerDto> saveCustomerInfo(@Body CustomerDto jsonparams);

    @GET("/account/customers")
    Call<List<CustomerDto>> findAllCustomers();

    @GET("/account/customer/{identification}")
    Call<CustomerDto> findById(@Path("identification") Long identification);

    @GET("/account/customer/id/{id}")
    Call<CustomerDto> findCustomerById(@Path("id") String id);

    @DELETE("/account/customer/id/{id}")
    Call<CustomerDto> deleteCustomer(@Path("id") String id);
}
