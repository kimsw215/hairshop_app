package kr.ac.kpu.ce2019152012.hair_you.service;

import static kr.ac.kpu.ce2019152012.hair_you.service.GpsService.getCurrentAddress;
import static kr.ac.kpu.ce2019152012.hair_you.service.GpsService.getLatitudeLongitude;

import org.junit.Test;

import java.util.ArrayList;

import kr.ac.kpu.ce2019152012.hair_you.R;
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi;
import kr.ac.kpu.ce2019152012.hair_you.api.ShopApi;
import kr.ac.kpu.ce2019152012.hair_you.dto.ShopDto;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GpsTest {
    String ip = String.valueOf(R.string.house_internal_ip);
    Retrofit rf = new Retrofit.Builder()
            .baseUrl("http://"+ip+":8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    CustomerApi customerApi = rf.create(CustomerApi.class);
    ShopApi shopApi = rf.create(ShopApi.class);


    @Test
    public void geocodingTest() throws Exception {
        String seoulCityHall = "서울 중구 세종대로 110 서울특별시청 태평로1가 31"; // 알고 있는 것
        double latitude;  // 알아야 할 것
        double longitude; // 알아야 할 것


        ArrayList list= getLatitudeLongitude(seoulCityHall);
        latitude=(double) list.get(0);
        longitude=(double) list.get(1);
        System.out.println("위도/경도 : " + latitude + " / " + longitude);


        // spring으로 전송(DB에 저장)
        ShopDto dto = new ShopDto();
        dto.setShopName("test545");
        dto.setAddress(seoulCityHall);
        dto.setLatitude(latitude);
        dto.setLongitude(longitude);
        dto.setInfo("미용실 설명");

        Call<ShopDto> convertedDto = shopApi.saveShop(dto);
        convertedDto.execute();


        /*
{
   "documents":[
      {
         "address":{
            "address_name":"서울 중구 태평로1가 31",
            "b_code":"1114010300",
            "h_code":"1114055000",
            "main_address_no":"31",
            "mountain_yn":"N",
            "region_1depth_name":"서울",
            "region_2depth_name":"중구",
            "region_3depth_h_name":"명동",
            "region_3depth_name":"태평로1가",
            "sub_address_no":"",
            "x":"126.977829174031",
            "y":"37.5663174209601"
         },
         "address_name":"서울 중구 세종대로 110",
         "address_type":"ROAD_ADDR",
         "road_address":{
            "address_name":"서울 중구 세종대로 110",
            "building_name":"서울특별시청",
            "main_building_no":"110",
            "region_1depth_name":"서울",
            "region_2depth_name":"중구",
            "region_3depth_name":"태평로1가",
            "road_name":"세종대로",
            "sub_building_no":"",
            "underground_yn":"N",
            "x":"126.977829174031",
            "y":"37.5663174209601",
            "zone_no":"04524"
         },
         "x":"126.977829174031",
         "y":"37.5663174209601"
      }
   ],
   "meta":{
      "is_end":true,
      "pageable_count":1,
      "total_count":1
   }
}
         */
    }

    @Test
    public void reverseGeocodingTest() throws Exception {
        double latitude = 37.566535;     // 알고 있는 것
        double longitude = 126.977969;   // 알고 있는 것
        String shopAddress ;             // 알아야 할 것

        shopAddress = getCurrentAddress(latitude, longitude);
        System.out.println(shopAddress);

        if(shopAddress != null) {
            // spring에 전송
            // dto로 body 맵핑
            ShopDto dto = new ShopDto();
            dto.setShopName("test");
            dto.setAddress(shopAddress);
            dto.setLongitude(longitude);
            dto.setLatitude(latitude);

            // 서버로 전송하는 메서드 호출출
           Call<ShopDto> convertedDto = shopApi.saveShop(dto);
            convertedDto.execute();
        }
        /*
{
   "meta":{
      "total_count":1
   },
   "documents":[
      {
         "road_address":{
            "address_name":"서울특별시 중구 세종대로 110",
            "region_1depth_name":"서울",
            "region_2depth_name":"중구",
            "region_3depth_name":"",
            "road_name":"세종대로",
            "underground_yn":"N",
            "main_building_no":"110",
            "sub_building_no":"",
            "building_name":"서울특별시청",
            "zone_no":"04524"
         },
         "address":{
            "address_name":"서울 중구 태평로1가 31",
            "region_1depth_name":"서울",
            "region_2depth_name":"중구",
            "region_3depth_name":"태평로1가",
            "mountain_yn":"N",
            "main_address_no":"31",
            "sub_address_no":"",
            "zip_code":""
         }
      }
   ]
}

         */
    }
}
