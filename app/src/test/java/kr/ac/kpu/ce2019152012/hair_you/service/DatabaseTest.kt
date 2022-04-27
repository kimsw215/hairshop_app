package kr.ac.kpu.ce2019152012.hair_you.service

import android.util.Log
import org.junit.Assert.assertEquals
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto
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

@RunWith(MockitoJUnitRunner::class)
class DatabaseTest{
    var rf : Retrofit = Retrofit.Builder()
        .baseUrl("http://172.30.1.3:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val customerApi = rf.create(CustomerApi::class.java)

    @Test
    fun serverTest() {
        var service  = rf.create(CustomerApi::class.java)

        val mockDto :CustomerDto = mock(CustomerDto::class.java)
        Mockito.`when`(mockDto.getId()).thenReturn("test")


        var dto =CustomerDto("name","testId","testpw","222","female")


        var convertedDto : Call<CustomerDto> = service.saveCustomerInfo(dto)
        var content : CustomerDto? = convertedDto.execute().body()
        println(convertedDto.request())
        assertEquals(content?.getId(), "testId")
    }


    @Test
    fun getTest() {
        var converted =customerApi.findCustomerById("testId")
        var result = converted.execute()
        println(result.body()?.identification)

        assertEquals(result.body()?.password, "testpw")


    }
}