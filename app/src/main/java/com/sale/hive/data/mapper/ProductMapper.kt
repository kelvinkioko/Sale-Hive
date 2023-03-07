package com.sale.hive.data.mapper

import com.sale.hive.data.local.entity.ProductEntity
import com.sale.hive.data.remote.dto.ProductDTO
import com.sale.hive.domain.model.ProductModel
import com.sale.hive.domain.model.VotesModel

class ProductMapper {
    companion object Mapper {
        fun ProductDTO.mapDTOToProductEntity(): ProductEntity {
            return ProductEntity(
                productID = productID,
                userID = userID,
                name = name,
                description = description,
                image = image,
                originalCost = originalCost,
                discountCost = discountCost,
                discountPercentage = discountPercentage,
                status = status,
                dateUpdated = dateUpdated,
                dateCreated = dateCreated
            )
        }
        fun ProductModel.mapToProductEntity(): ProductEntity {
            return ProductEntity(
                productID = productID,
                userID = userID,
                name = name,
                description = description,
                image = image,
                originalCost = originalCost,
                discountCost = discountCost,
                discountPercentage = discountPercentage,
                status = status,
                dateUpdated = dateUpdated,
                dateCreated = dateCreated
            )
        }

        fun ProductEntity.mapToProductModel(productVotes: List<VotesModel>): ProductModel {
            return ProductModel(
                productID = productID,
                userID = userID,
                name = name,
                description = description,
                image = image,
                originalCost = originalCost,
                discountCost = discountCost,
                discountPercentage = discountPercentage,
                status = status,
                dateUpdated = dateUpdated,
                dateCreated = dateCreated,
                votes = productVotes
            )
        }
    }
}
