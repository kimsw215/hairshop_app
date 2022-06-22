package kr.ac.kpu.ce2019152012.hair_you.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchDataVo(
    val ShopName: String,
    val ShopAdd1: String,
    val ShopAdd2: String
): Parcelable