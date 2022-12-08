package com.example.basicdagger2.model

import java.io.Serializable


class ProductDataModel : ArrayList<ProductItem>(),Serializable

data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

data class Rating(
    val count: Int,
    val rate: Double
)
