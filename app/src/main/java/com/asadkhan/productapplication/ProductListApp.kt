package com.asadkhan.productapplication

import android.app.Application

class ProductListApp : Application() {

  companion object {
    private lateinit var app: ProductListApp

    fun getApp() = app
  }

  override fun onCreate() {
    app = this
    super.onCreate()
  }
}
