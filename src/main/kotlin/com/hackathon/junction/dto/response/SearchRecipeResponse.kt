package com.hackathon.junction.dto.response

import com.hackathon.junction.entity.Product
import com.hackathon.junction.entity.RecipeStatus

data class SearchRecipeResponse(
    val id: Long,
    val description: String,
    val category: String,
    val product: Product,
    val status: RecipeStatus,
    val imgUrl: String? = null,
)