package com.hackathon.junction.dto

import com.hackathon.junction.entity.OptionType

data class OptionDto(
    val id: Long,
    val type: OptionType,
    val title: String,
    val values: List<OptionValueDto>,
)