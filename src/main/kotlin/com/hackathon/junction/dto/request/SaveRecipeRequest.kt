package com.hackathon.junction.dto.request

import com.hackathon.junction.dto.StepDto
import com.hackathon.junction.entity.RecipeStatus

data class SaveRecipeRequest(
    val recipeId: Long? = null, // id 값이 있으면 이미지 PUBLIC 지정 필요
    val productId: Long,
    val category: String,
    val description: String,
    val steps: List<StepDto>,
    val status: RecipeStatus = RecipeStatus.PRIVATE,
    val imgUrl: String? = null, // TODO: S3 이미지 저장
)