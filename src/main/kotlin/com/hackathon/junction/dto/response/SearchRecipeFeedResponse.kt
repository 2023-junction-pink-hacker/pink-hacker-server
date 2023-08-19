package com.hackathon.junction.dto.response

import com.hackathon.junction.entity.RecipeStatus

data class SearchRecipeFeedResponse(
    val id: Long,
    val description: String,
    val category: String,
    val productId: Long,
    val status: RecipeStatus,
    val orderCount: Int = 0,
    val imgUrl: String? = null,
)