package com.sale.hive.data.remote

import com.squareup.moshi.Json

data class APIResponse<T>(
    @field:Json(name = "status_code") var statusCode: String = "",
    @field:Json(name = "status_message") var statusMessage: String = "",
    @field:Json(name = "products") var products: T? = null,
)
