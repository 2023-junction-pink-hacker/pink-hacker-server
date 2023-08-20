package com.hackathon.junction.dto.response

import com.hackathon.junction.entity.RecipeStatus
import java.time.LocalDateTime

data class SearchRecentOrderResponse(
    val name: String,
    val category: String,
    val productId: Long,
    val orderCount: Int = 0,
    val description: String = "",
    val status: RecipeStatus = RecipeStatus.PRIVATE,
    val imgUrl: String? = null,
    val id: Long,
    var createdDate: LocalDateTime? = null,
    var lastModifiedDate: LocalDateTime? = null
)