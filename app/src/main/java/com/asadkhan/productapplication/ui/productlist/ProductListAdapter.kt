package com.asadkhan.productapplication.ui.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.asadkhan.productapplication.R
import com.asadkhan.productapplication.domain.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.product_item_row.view.*

class ProductListAdapter : ListAdapter<Product, ProductViewHolder>(ProductDiffUtil()) {

  private val items = ArrayList<Product>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
    val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.product_item_row, parent, false)
    return ProductViewHolder(inflatedView)
  }

  override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
    val data = items[position]
    holder.itemView.apply {

      tv_product_name.text = data.title
      tv_product_weight.text = data.quantity
      tv_product_price.text = data.originalPrice

      val imageLoader = Glide.with(context)
      if (data.imageUrl.isNullOrBlank()) {
        imageLoader
          .load(R.drawable.ic_error_outline_28)
          .into(iv_product_thumbnail)
      } else {
        imageLoader
          .load(data.imageUrl)
          .centerCrop()
          .placeholder(R.drawable.ic_launcher_background)
          .error(R.drawable.ic_error_outline_red_28)
          .into(iv_product_thumbnail)
      }

    }
  }

  fun addItems(newItems: List<Product>) {
    items.clear()
    items.addAll(newItems)
    // Ignoring warning for the time being, can replace with `notifyItemRangeInserted` later
    notifyDataSetChanged()
  }

  override fun getItemCount() = items.size
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class ProductDiffUtil : DiffUtil.ItemCallback<Product>() {
  override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
    return oldItem == newItem
  }

}
