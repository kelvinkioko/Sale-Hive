package com.sale.hive.domain.repository

import com.sale.hive.domain.model.ProductModel

interface ProductRepository {
    suspend fun insertProduct(productModel: ProductModel)

    suspend fun loadProducts(): List<ProductModel>

    suspend fun loadProduct(productID: String): ProductModel

    suspend fun deleteProduct(productModel: ProductModel)
}
