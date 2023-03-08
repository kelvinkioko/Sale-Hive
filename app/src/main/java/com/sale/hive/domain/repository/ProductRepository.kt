package com.sale.hive.domain.repository

import com.sale.hive.domain.model.ProductModel
import com.sale.hive.util.Response

interface ProductRepository {
    suspend fun insertProduct(productModel: ProductModel)

    suspend fun loadProducts(): Response<List<ProductModel>>

    suspend fun loadProduct(productID: String): Response<ProductModel>

    suspend fun deleteProduct(productModel: ProductModel)
}
