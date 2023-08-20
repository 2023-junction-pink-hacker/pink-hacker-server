package com.hackathon.junction.dto.request

import com.hackathon.junction.entity.RecipeStatus

data class UpdateRecipeRequest(
    val recipeId: Long,
    val imgUrl: String,
    val description: String,
    val status: RecipeStatus = RecipeStatus.PUBLIC
)