package com.asadkhan.productapplication.data

import android.content.res.Resources
import com.asadkhan.productapplication.ProductListApp
import com.asadkhan.productapplication.R
import com.asadkhan.productapplication.domain.ProductListResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader

class ProductRepository {

  private val gson: Gson by lazy { GsonBuilder().create() }
  private val resources by lazy { ProductListApp.getApp().resources }

  private suspend fun getProductListRawString(): String {
    return resources.openRawResource(R.raw.product_list).bufferedReader().use(BufferedReader::readText)
  }

  suspend fun getProductList(): ProductListResponse {
    val productListRawString = getProductListRawString()
    return gson.fromJson(productListRawString, ProductListResponse::class.java)
  }

}
