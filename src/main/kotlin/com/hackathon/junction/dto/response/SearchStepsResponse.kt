package com.hackathon.junction.dto.response

import com.hackathon.junction.dto.StepDto

data class SearchStepsResponse(
    val productId: Long,
    val steps: List<StepDto>
)