package com.sale.hive.data.remote

import com.sale.hive.data.remote.dto.ProductDTO
import retrofit2.http.GET

interface SaleHiveApi {

    @GET("bd6c9929-511c-4bda-9134-5fc120a2cf40")
    suspend fun getProducts(): List<ProductDTO>
}
