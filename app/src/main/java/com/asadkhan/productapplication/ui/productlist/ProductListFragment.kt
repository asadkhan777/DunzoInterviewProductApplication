package com.asadkhan.productapplication.ui.productlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.asadkhan.productapplication.ProductListApp.Companion.getApp
import com.asadkhan.productapplication.R
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment : Fragment() {

  private val productListAdapter by lazy { ProductListAdapter() }
  private val productListViewModel by lazy { ViewModelProvider(requireActivity())[ProductListViewModel::class.java] }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_product_list, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    rv_product_list.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = productListAdapter
    }

    productListViewModel.productListLiveData.observe(viewLifecycleOwner) { list ->
      if (list != null && list.isNotEmpty()) {
        pb_loading.visibility = GONE
        productListAdapter.addItems(list)
      } else {
        Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
      }
    }

    productListViewModel.loadingLiveData.observe(viewLifecycleOwner) { showLoading ->
      if (showLoading != null && showLoading) {
        pb_loading.visibility = VISIBLE
      } else {
        pb_loading.visibility = GONE
      }
    }

    iv_product_search.setOnClickListener {
      context?.toast("Search not yet implemented")
    }

    productListViewModel.getProductList()
  }

}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
  Toast.makeText(this, message, duration).show()
}
