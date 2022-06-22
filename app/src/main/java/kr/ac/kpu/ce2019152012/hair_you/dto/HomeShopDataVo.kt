package kr.ac.kpu.ce2019152012.hair_you.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeShopDataVo(
    val shopname: String,
    val shop_address_name: String,
    val shop_road_name: String
) : Parcelable