package com.asadkhan.productapplication.domain


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductListResponse(
  @SerializedName("items") val items: Items
) : Parcelable
