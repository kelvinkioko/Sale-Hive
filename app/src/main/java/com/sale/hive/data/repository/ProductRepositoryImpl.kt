package com.sale.hive.data.repository

import com.sale.hive.data.local.dao.ProductDao
import com.sale.hive.data.local.dao.VotesDao
import com.sale.hive.data.local.entity.ProductEntity
import com.sale.hive.data.mapper.ProductMapper.Mapper.mapDTOToProductEntity
import com.sale.hive.data.mapper.ProductMapper.Mapper.mapToProductEntity
import com.sale.hive.data.mapper.ProductMapper.Mapper.mapToProductModel
import com.sale.hive.data.mapper.Votes.Mapper.mapDTOToVotesEntity
import com.sale.hive.data.mapper.Votes.Mapper.mapToVotesModel
import com.sale.hive.data.remote.SaleHiveApi
import com.sale.hive.data.remote.dto.ProductDTO
import com.sale.hive.domain.model.ProductModel
import com.sale.hive.domain.model.VotesModel
import com.sale.hive.domain.repository.ProductRepository
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val saleHiveApi: SaleHiveApi,
    private val productDao: ProductDao,
    private val votesDao: VotesDao
) : ProductRepository {
    override suspend fun insertProduct(productModel: ProductModel) {
        val productEntity = productModel.mapToProductEntity()

        productDao.insertProduct(productEntity = productEntity)
    }

    override suspend fun loadProducts(): List<ProductModel> {
        try {
            val remoteProducts = saleHiveApi.getProducts()

            cacheRemoteProductsAndVotes(remoteProducts = remoteProducts)
        } catch (httpException: HttpException) {
            return emptyList()
        }

        val listOfProducts = mutableListOf<ProductModel>()

        val products = productDao.loadProducts()

        products.map { productEntity ->
            val productVotes = getListOfVotes(productID = productEntity.productID)
            listOfProducts.add(productEntity.mapToProductModel(productVotes = productVotes))
        }
        return listOfProducts
    }

    private suspend fun cacheRemoteProductsAndVotes(remoteProducts: List<ProductDTO>) {
        remoteProducts.map { productDTO ->
            val productEntity = productDTO.mapDTOToProductEntity()
            productDao.insertProduct(productEntity = productEntity)

            productDTO.votes.map { votesDTO ->
                val votesEntity = votesDTO.mapDTOToVotesEntity()
                votesDao.insertVotes(votesEntity = votesEntity)
            }
        }
    }

    private suspend fun getListOfVotes(productID: String): List<VotesModel> {
        return votesDao.loadVotes(productID = productID).mapToVotesModel()
    }

    override suspend fun loadProduct(productID: String): ProductModel {
        val productEntity = productDao.loadProduct(productID = productID) ?: ProductEntity()
        val productVotes = getListOfVotes(productID = productID)

        return productEntity.mapToProductModel(productVotes = productVotes)
    }

    override suspend fun deleteProduct(productModel: ProductModel) {
        val productEntity = productModel.mapToProductEntity()

        productDao.deleteProduct(productEntity = productEntity)
    }
}
