package com.sale.hive.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sale.hive.R
import com.sale.hive.databinding.ItemProductBinding
import com.sale.hive.domain.model.ProductModel

class ProductsAdapter : ListAdapter<ProductModel, ProductsAdapter.ViewHolder>(DIFF_UTIL) {

    private val images = mutableListOf(R.drawable.samsung_two, R.drawable.microwave)
    private var iterate: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(product = currentList[position])
    }

    inner class ViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductModel) {
            binding.apply {
                productIcon.background = AppCompatResources.getDrawable(
                    productIcon.context,
                    images[iterate]
                )

                iterate = if (iterate == 0) 1 else 0

                productTitle.text = product.name
                newPrice.text = product.discountCost
                oldPrice.text = product.originalCost
                upVote.text = product.votes.count { it.upVote }.toString()
                downVote.text = product.votes.count { it.downVote }.toString()
            }
        }
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<ProductModel>() {
            override fun areItemsTheSame(
                oldItem: ProductModel,
                newItem: ProductModel
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: ProductModel,
                newItem: ProductModel
            ): Boolean = oldItem == newItem
        }
    }
}
