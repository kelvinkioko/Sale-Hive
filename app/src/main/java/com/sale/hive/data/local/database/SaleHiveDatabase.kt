package com.sale.hive.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sale.hive.data.local.dao.ProductDao
import com.sale.hive.data.local.dao.VotesDao
import com.sale.hive.data.local.entity.ProductEntity
import com.sale.hive.data.local.entity.VotesEntity

@Database(
    entities = [
        ProductEntity::class,
        VotesEntity::class
    ],
    version = 1
)
abstract class SaleHiveDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun votesDao(): VotesDao
}
