package com.sale.hive.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.sale.hive.content.ProductContent.Content.fridgeEntity
import com.sale.hive.content.ProductContent.Content.microwaveEntity
import com.sale.hive.data.local.database.SaleHiveDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@SmallTest
class ProductDaoTest {

    private lateinit var saleHiveDatabase: SaleHiveDatabase
    private lateinit var productDao: ProductDao

    @Before
    fun setup() {
        saleHiveDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SaleHiveDatabase::class.java
        ).allowMainThreadQueries().build()

        productDao = saleHiveDatabase.productDao()
    }

    @Test
    fun insertProducts() = runBlocking {
        productDao.insertProduct(productEntity = fridgeEntity)
        productDao.insertProduct(productEntity = microwaveEntity)

        val savedProducts = productDao.loadProducts()

        assertThat(savedProducts).contains(fridgeEntity)
    }

    @Test
    fun loadProducts() = runBlocking {
        productDao.insertProduct(productEntity = fridgeEntity)

        val savedProducts = productDao.loadProducts()

        assertThat(savedProducts).isNotEmpty()
    }

    @Test
    fun loadProductByID() = runBlocking {
        productDao.insertProduct(productEntity = fridgeEntity)
        productDao.insertProduct(productEntity = microwaveEntity)

        val savedProduct = productDao.loadProduct(productID = fridgeEntity.productID)

        assertThat(savedProduct).isEqualTo(fridgeEntity)
    }

    @Test
    fun loadNonExistentProductByID() = runBlocking {
        productDao.insertProduct(productEntity = microwaveEntity)

        val savedProduct = productDao.loadProduct(productID = fridgeEntity.productID)

        assertThat(savedProduct).isNull()
    }

    @Test
    fun deleteProduct() = runBlocking {
        productDao.insertProduct(productEntity = fridgeEntity)
        productDao.insertProduct(productEntity = microwaveEntity)
        productDao.deleteProduct(productEntity = microwaveEntity)

        val deletedProduct = productDao.loadProduct(productID = microwaveEntity.productID)

        assertThat(deletedProduct).isNull()
    }
}
