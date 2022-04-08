package kr.ac.kpu.ce2019152012.hair_you.api;

import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto;
import kr.ac.kpu.ce2019152012.hair_you.dto.DesignerDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DesignerApi {
    @POST("/account/designer")
    Call<DesignerDto> saveDesignerInfo(@Body DesignerDto dto);

    @GET("/account/designers")
    Call<List<DesignerDto>> findAllDesigners();

    @GET("/account/designer/identification")
    Call<DesignerDto> findById(@Path("identification") Long identification);

    @GET("/account/designer/id/{id}")
    Call<DesignerDto> findDesignerById(@Path("id") String id);


    @DELETE("/account/designer/id/{id}")
    Call<DesignerDto> deleteDesigner(@Path("id") String id);

}
