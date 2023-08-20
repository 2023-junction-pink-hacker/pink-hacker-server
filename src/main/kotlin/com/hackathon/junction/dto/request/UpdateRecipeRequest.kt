package com.hackathon.junction.dto.request

data class UpdateRecipeRequest(
    val recipeId: Long,
    val imgUrl: String,
    val description: String
)