package com.sale.hive.domain.model

data class ProductModel(
    var productID: String = "",
    var userID: String = "",
    var name: String = "",
    var description: String = "",
    var image: String = "",
    var originalCost: String = "",
    var discountCost: String = "",
    var discountPercentage: String = "",
    var status: String = "",
    var dateUpdated: String = "",
    var dateCreated: String = "",
    var votes: List<VotesModel> = emptyList()
)
