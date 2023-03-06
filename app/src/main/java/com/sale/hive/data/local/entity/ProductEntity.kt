package com.sale.hive.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "products", primaryKeys = ["product_id", "user_id"])
data class ProductEntity(
    @ColumnInfo(name = "product_id") var productID: String = "",
    @ColumnInfo(name = "user_id") var userID: String = "",
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "image") var image: String = "",
    @ColumnInfo(name = "original_cost") var originalCost: String = "",
    @ColumnInfo(name = "discount_cost") var discountCost: String = "",
    @ColumnInfo(name = "discount_percentage") var discountPercentage: String = "",
    @ColumnInfo(name = "status") var status: String = "",
    @ColumnInfo(name = "date_updated") var dateUpdated: String = "",
    @ColumnInfo(name = "date_created") var dateCreated: String = ""
)
