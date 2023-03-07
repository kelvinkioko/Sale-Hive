package com.sale.hive.data.remote.dto

import com.squareup.moshi.Json

data class ProductDTO(
    @field:Json(name = "productID") var productID: String = "",
    @field:Json(name = "userID") var userID: String = "",
    @field:Json(name = "name") var name: String = "",
    @field:Json(name = "description") var description: String = "",
    @field:Json(name = "image") var image: String = "",
    @field:Json(name = "originalCost") var originalCost: String = "",
    @field:Json(name = "discountCost") var discountCost: String = "",
    @field:Json(name = "discountPercentage") var discountPercentage: String = "",
    @field:Json(name = "status") var status: String = "",
    @field:Json(name = "dateUpdated") var dateUpdated: String = "",
    @field:Json(name = "dateCreated") var dateCreated: String = "",
    @field:Json(name = "votes") var votes: List<VotesDTO> = emptyList()
)
