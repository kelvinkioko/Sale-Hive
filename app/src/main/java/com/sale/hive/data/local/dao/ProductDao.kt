package com.sale.hive.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sale.hive.data.local.entity.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM products WHERE status ='Active'")
    suspend fun loadProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE product_id =:productID")
    suspend fun loadProduct(productID: String): ProductEntity?

    @Delete
    suspend fun deleteProduct(productEntity: ProductEntity)
}
