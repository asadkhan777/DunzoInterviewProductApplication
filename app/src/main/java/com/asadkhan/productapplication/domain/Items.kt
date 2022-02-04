package com.asadkhan.productapplication.domain


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items(
  @SerializedName("product_list") val productList: List<Product>,
  @SerializedName("total") val total: Int // 20
) : Parcelable
