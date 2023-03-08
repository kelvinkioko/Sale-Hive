package com.sale.hive.data.mapper

import com.google.common.truth.Truth.assertThat
import com.sale.hive.content.ProductContent.Content.fridgeDTO
import com.sale.hive.content.ProductContent.Content.fridgeEntity
import com.sale.hive.content.ProductContent.Content.fridgeModel
import com.sale.hive.content.ProductContent.Content.microwaveEntity
import com.sale.hive.content.ProductContent.Content.microwaveModel
import com.sale.hive.data.mapper.ProductMapper.Mapper.mapDTOToProductEntity
import com.sale.hive.data.mapper.ProductMapper.Mapper.mapToProductEntity
import com.sale.hive.data.mapper.ProductMapper.Mapper.mapToProductModel
import org.junit.Test

class ProductMapperTests {

    @Test
    fun `test mapping productDTO to productEntity`() {
        val mappedEntity = fridgeDTO.mapDTOToProductEntity()

        assertThat(mappedEntity).isEqualTo(fridgeEntity)
    }

    @Test
    fun `test mapping productEntity to productModel`() {
        val mappedModel = microwaveEntity.mapToProductModel(productVotes = emptyList())

        assertThat(mappedModel).isEqualTo(microwaveModel)
    }

    @Test
    fun `test mapping productModel to productEntity`() {
        val mappedEntity = fridgeModel.mapToProductEntity()

        assertThat(mappedEntity).isEqualTo(fridgeEntity)
    }
}