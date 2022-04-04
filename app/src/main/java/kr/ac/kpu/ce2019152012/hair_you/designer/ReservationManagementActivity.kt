package kr.ac.kpu.ce2019152012.hair_you.designer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.PlacesApi
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.databinding.ActivityReservationManagementBinding
import kr.ac.kpu.ce2019152012.hair_you.service.GpsTracker

class ReservationManagementActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityReservationManagementBinding
    private lateinit var gpsTracker: GpsTracker

    private lateinit var map : GoogleMap
    private lateinit var currentMarker : Marker
    private  var latitude :  Double = 0.0
    private  var longitude :Double =0.0

    override fun onMapReady(googleMap: GoogleMap) {
        val seoulCityHall = LatLng(37.566535, 126.977969)
        map = googleMap

        // 서울 시청 위에 마크 표시
        googleMap.addMarker(
            MarkerOptions()
                .position(seoulCityHall)
                .title("서울")
                .snippet("시청")
        )
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(seoulCityHall,10F)) // 지정한 위치로 카메라 이동, zoom 단계 10단계
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getMapAsync() 메소드가 메인 쓰레드에서 호출되어야 메인스레드에서 onMapReady 콜백이 실행됨
        val mapFragment :SupportMapFragment = getSupportFragmentManager()
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // 현재 위치 가져오기

        // 구글맵스플랫폼 : https://developers.google.com/maps/documentation/android-sdk/current-place-tutorial?hl=ko#kotlin
        // https://webnautes.tistory.com/647

        //gpsTracker = GpsTracker(this@ReservationManagementActivity)


        //var curAddress :String = getCurrentAddress(latitude, longitude)

        binding.curLocationBtn.setOnClickListener {
            gpsTracker = GpsTracker(this@ReservationManagementActivity)
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
            Log.i("gps", "onCreate: 위도 : "+latitude+ " / 경도 : "+longitude)
            // AVD 위치가 미국 어딘가로 뜸 -> 위도:36? 경도 -122..
        }

    }

    /*
    @SuppressLint("MissingPermission")
    private fun updateLocationUI() {
        if (map ==null) {
            return
        }

        try{
            if (locationPermissionGranted){
                map?.isMyLocationEnabled = true
                map?.uiSettings?.isMyLocationButtonEnabled = true
            } else {
                map?.isMyLocationEnabled =false
                map?.uiSettings?.isMyLocationButtonEnabled =false
                lastKnownLocation = null
                getLocationPermission()
            }
        } catch (e:SecurityException){
        Log.i("gps", "updateLocationUI: "+e.toString())
        }
    }

     */


}
