package com.hackathon.junction.dto.response

import com.hackathon.junction.entity.Product
import com.hackathon.junction.entity.RecipeStatus

data class SearchRecipeFeedResponse(
    val id: Long,
    val description: String,
    val category: String,
    val product: Product,
    val status: RecipeStatus,
    val orderCnt: Int = 0,
    val imgUrl: String? = null,
)