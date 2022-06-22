package kr.ac.kpu.ce2019152012.hair_you.service

import Place
import ResultSearchKeyword
import kr.ac.kpu.ce2019152012.hair_you.api.KakaoApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KakaoApiTest {
    var rf : Retrofit = Retrofit.Builder()
        .baseUrl("https://dapi.kakao.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val rf2 : Retrofit= RetrofitClient.getKakao()
    val kakaoApi=rf2.create(KakaoApi::class.java)
    val KAKAO_API_KEY = "KakaoAK 6c15981489ac8f7193df22c979df29f2"

    @Test
    fun 데이터_가져오기(){
        var place_name: String="@@@@@@@@@@@@@"             // 장소명, 업체명
        var address_name: String           // 전체 지번 주소
        var road_address_name: String      // 전체 도로명 주소
        var x: String                      // X 좌표값 혹은 longitude
        var y: String                      // Y 좌표값 혹은 latitude

        val call = kakaoApi.getSearchKeyword(KAKAO_API_KEY,"미용실","126.733627","37.3400927",20000)
        var listOfPlace = call.execute().body()!!.documents

        place_name=listOfPlace[0].place_name
        address_name=listOfPlace[0].address_name
        road_address_name=listOfPlace[0].road_address_name
        println(place_name)
        println(address_name)
        println(road_address_name)
    }

}