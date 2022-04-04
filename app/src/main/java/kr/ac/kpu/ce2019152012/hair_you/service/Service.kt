package kr.ac.kpu.ce2019152012.hair_you.service

import android.util.Log
import retrofit2.Retrofit
import kr.ac.kpu.ce2019152012.hair_you.api.RetrofitClient
import kr.ac.kpu.ce2019152012.hair_you.api.DesignerApi
import kr.ac.kpu.ce2019152012.hair_you.api.CustomerApi
import kr.ac.kpu.ce2019152012.hair_you.api.ReservationApi
import kr.ac.kpu.ce2019152012.hair_you.dto.CustomerDto
import kr.ac.kpu.ce2019152012.hair_you.dto.ReservationDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Services {
    var retrofit = RetrofitClient.getClient()
    var designerApi = retrofit.create(DesignerApi::class.java)
    var customerApi = retrofit.create(CustomerApi::class.java)
    var reservationApi=retrofit.create(ReservationApi::class.java)


    // 고객 정보 저장
    fun saveCustomerInfo(dto: CustomerDto){
    // 여기서부터
    customerApi.saveCustomerInfo(dto).enqueue( object : Callback<CustomerDto> {
        override fun onResponse(call: Call<CustomerDto>, response: Response<CustomerDto>) {
            Log.d("join", "onResponse: " + response.body()?.getName() + " 님 회원가입")
            /*
            코드 작성
             */
        }
        override fun onFailure(call: Call<CustomerDto>, t: Throwable) {
            Log.d("join", "onFailure: $t")
        }
    })
    // 여기까지 복사해서 사용
    }

    // 예약 저장 : response.body() == ReservationDto
    fun saveReservation(dto : ReservationDto) {
        reservationApi.saveReservation(dto).enqueue(object : Callback<ReservationDto>{
            override fun onResponse(
                call: Call<ReservationDto>,
                response: Response<ReservationDto>
            ) {
                Log.d("reservation", "onResponse: " + response.body()?.getcId())
            }

            override fun onFailure(call: Call<ReservationDto>, t: Throwable) {
                Log.d("reservation", "onFailure: "+t)
            }
        })

        // 전체 예약 조회 : response.body() == List<ReservationDto>
        fun indexAllReservations(){
            reservationApi.findAllReservations().enqueue(object :Callback<List<ReservationDto>>{
                override fun onResponse(
                    call: Call<List<ReservationDto>>,
                    response: Response<List<ReservationDto>>
                ) {
                    /*
                    ex) 이런식으로 사용
                    binding.텍스트필드아이디.setText=response.body()?.get(1)?.getShopId()
                    for(~){
                    response.body().get(i) ...
                    }
                     */

                }

                override fun onFailure(call: Call<List<ReservationDto>>, t: Throwable) {
                    Log.d("reservation", "onFailure: "+ t)
                }
            })
        }

        // 고객 아이디로 예약 조회
        fun findReserByCId(){
            var id :String="조회할아이디입력"
            reservationApi.findByCustomerId(id).enqueue(object :Callback<List<ReservationDto>>{
                override fun onResponse(
                    call: Call<List<ReservationDto>>,
                    response: Response<List<ReservationDto>>
                ) {
                    Log.d("reservation", "onResponse: 고객 아이디로 예약 조회")
                }

                override fun onFailure(call: Call<List<ReservationDto>>, t: Throwable) {
                    Log.d("reservation", "onFailure: "+ t)
                }
            })
        }

        // 고객 아이디로 예약 조회
        fun findReserByShopName(){
            var shopname :String="조회할미용실이름입력"
            reservationApi.findByShopName(shopname).enqueue(object :Callback<List<ReservationDto>>{
                override fun onResponse(
                    call: Call<List<ReservationDto>>,
                    response: Response<List<ReservationDto>>
                ) {
                    Log.d("reservation", "onResponse: 미용실 별로 예약 조회")
                }

                override fun onFailure(call: Call<List<ReservationDto>>, t: Throwable) {
                    Log.d("reservation", "onFailure: "+ t)
                }
            })
        }

        // 고객 아이디로 고객 정보 조회
        fun findByCId(){
            var id : String = "조회할고객아이디"

            customerApi.findCustomerById(id).enqueue(object : Callback<CustomerDto>{
                override fun onResponse(call: Call<CustomerDto>, response: Response<CustomerDto>) {

                }

                override fun onFailure(call: Call<CustomerDto>, t: Throwable) {
                }
            })
        }

    }
}