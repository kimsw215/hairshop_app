package kr.ac.kpu.ce2019152012.hair_you.api;

import java.util.List;

import kr.ac.kpu.ce2019152012.hair_you.dto.ShopDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ShopApi {

    @GET("/shop")
    Call<List<ShopDto>> findAllShops();

    @GET("/shop/name/{shop_name}")
    Call<ShopDto> findShopByName(@Path("shop_name") String shopName);

    @POST("/shop")
    Call<ShopDto> saveShop(@Body ShopDto dto);
}
