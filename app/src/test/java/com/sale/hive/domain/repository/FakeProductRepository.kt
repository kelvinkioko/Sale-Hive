package com.sale.hive.domain.repository

import com.sale.hive.content.ProductContent.Content.fridgeModel
import com.sale.hive.content.ProductContent.Content.microwaveModel
import com.sale.hive.domain.model.ProductModel
import com.sale.hive.util.Response

class FakeProductRepository : ProductRepository {
    override suspend fun insertProduct(productModel: ProductModel) {}

    override suspend fun loadProducts(): Response<List<ProductModel>> {
        val products = mutableListOf(
            fridgeModel,
            microwaveModel
        )
        return Response.Success(responseData = products)
    }

    override suspend fun loadProduct(productID: String): Response<ProductModel> {
        return Response.Success(responseData = fridgeModel)
    }

    override suspend fun deleteProduct(productModel: ProductModel) {}
}