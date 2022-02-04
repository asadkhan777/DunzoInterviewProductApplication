package com.asadkhan.productapplication.ui.productlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asadkhan.productapplication.data.ProductRepository
import com.asadkhan.productapplication.domain.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductListViewModel: ViewModel() {

  private val repository by lazy { ProductRepository() }
  val productListLiveData = MutableLiveData<List<Product>>()
  val loadingLiveData = MutableLiveData<Boolean>()

  fun getProductList() {
    loadingLiveData.value = true
    viewModelScope.launch {
      val list = withContext(Dispatchers.IO) {
        val productListResponse = repository.getProductList()
        productListResponse.items.productList
      }
      productListLiveData.postValue(list)
      loadingLiveData.postValue(false)
    }
  }
}
