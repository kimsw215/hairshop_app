package kr.ac.kpu.ce2019152012.hair_you.service

import android.util.Log
import org.junit.Assert.assertEquals
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi
import kr.ac.kpu.ce2019152012.hair_you.api.ReservationApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.api.ShopApi
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto
import kr.ac.kpu.ce2019152012.hair_you.dto.ReservationDto
import kr.ac.kpu.ce2019152012.hair_you.dto.ShopDto
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

@RunWith(MockitoJUnitRunner::class)
class DatabaseTest {
    var rf: Retrofit = Retrofit.Builder()
        .baseUrl("http://172.30.1.3:8080")
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val shopApi = rf.create(ShopApi::class.java)
    val customerApi = rf.create(CustomerApi::class.java)
    val reservationApi = rf.create(ReservationApi::class.java)

    @Test
    fun serverTest() {
        var service = rf.create(CustomerApi::class.java)

        val mockDto: CustomerDto = mock(CustomerDto::class.java)
        Mockito.`when`(mockDto.getId()).thenReturn("test")


        var dto = CustomerDto("name", "testId", "testpw", "222", "female")


        var convertedDto: Call<CustomerDto> = service.saveCustomerInfo(dto)
        var content: CustomerDto? = convertedDto.execute().body()
        println(convertedDto.request())
        assertEquals(content?.getId(), "testId")
    }


    @Test
    fun getTest() {
        var converted = customerApi.findCustomerById("testId")
        var result = converted.execute()
        println(result.body()?.identification)

        assertEquals(result.body()?.password, "testpw")

    }

    @Test
    fun getReservationsListTest() {
        // 예약 내역 출력 테스트
        var call: Call<List<ReservationDto>> = reservationApi.findAllReservations()
        var result: List<ReservationDto>? = call.execute().body()

        if (result != null) {
            for (i in 0..result.size - 1) {
                println("현재 상태 : " + result.get(i).curCondition + " / 디테일 : " + result.get(i).detail
                +" / 미용실이름 :"+result.get(i).shopId.shopName)
            }
        }

    }

    @Test
    fun getShopInfoTest() {
        // 미용실 이름으로 조회
        var call: Call<ShopDto> = shopApi.findShopByName("testshop2")
        var result: ShopDto

        result = call.execute().body()!!
        println(result.getAllInfo())

        // 모든 미용실 조회 (미용실 리스트)
        var call2: Call<List<ShopDto>> = shopApi.findAllShops()
        var result2: List<ShopDto>
        result2 = call2.execute().body()!!

        for (i in 0..result2.size - 1) {
            println(result2.get(i).allInfo)
        }
    }
}