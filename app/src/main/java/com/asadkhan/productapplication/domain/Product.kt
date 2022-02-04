package com.asadkhan.productapplication.domain


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
  @SerializedName("discount_percentage") val discountPercentage: String, // 20% off
  @SerializedName("id") val id: String, // 12047048191
  @SerializedName("image_url") val imageUrl: String?, // https://farm66.staticflickr.com/65535/51828764621_90b99bb7fa_m.jpg
  @SerializedName("offer_price") val offerPrice: String?, // Rs. 104
  @SerializedName("original_price") val originalPrice: String, // Rs. 40
  @SerializedName("quantity") val quantity: String, // 1 Kg
  @SerializedName("title") val title: String // Tomato
) : Parcelable
