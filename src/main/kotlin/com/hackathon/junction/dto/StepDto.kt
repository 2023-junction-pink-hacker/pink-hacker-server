package com.hackathon.junction.dto

data class StepDto(
    val id: Long,
    val name: String,
    val position: Int,
    val options: List<OptionDto>
)