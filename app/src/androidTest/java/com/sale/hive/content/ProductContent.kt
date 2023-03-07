package com.sale.hive.content

import com.sale.hive.data.local.entity.ProductEntity
import com.sale.hive.domain.model.ProductModel

class ProductContent {
    companion object Content {
        val fridgeEntity = ProductEntity(
            productID = "PRD001",
            userID = "USR001",
            name = "Side-by-Side Refrigerator, 641 Net Capacity",
            description = "Side-by-Side Refrigerator, 641 Net Capacity",
            image = "",
            originalCost = "120,000.00 KES",
            discountCost = "79,000.00 KES",
            discountPercentage = "34%",
            status = "Active",
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveEntity = ProductEntity(
            productID = "PRD002",
            userID = "USR001",
            name = "Grill Microwave Oven, 40L",
            description = "Grill Microwave Oven, 40L. 1300W (Grill) / 1600W (Microwave), Ceramic Enamel",
            image = "",
            originalCost = "20,000.00 KES",
            discountCost = "15,000.00 KES",
            discountPercentage = "25%",
            status = "Active",
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val fridgeModel = ProductModel(
            productID = "PRD001",
            userID = "USR001",
            name = "Side-by-Side Refrigerator, 641 Net Capacity",
            description = "Side-by-Side Refrigerator, 641 Net Capacity",
            image = "",
            originalCost = "120,000.00 KES",
            discountCost = "79,000.00 KES",
            discountPercentage = "34%",
            status = "Active",
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveModel = ProductModel(
            productID = "PRD002",
            userID = "USR001",
            name = "Grill Microwave Oven, 40L",
            description = "Grill Microwave Oven, 40L. 1300W (Grill) / 1600W (Microwave), Ceramic Enamel",
            image = "",
            originalCost = "20,000.00 KES",
            discountCost = "15,000.00 KES",
            discountPercentage = "25%",
            status = "Active",
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )
    }
}
