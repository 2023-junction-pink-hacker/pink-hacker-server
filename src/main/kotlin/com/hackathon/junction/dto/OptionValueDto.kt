package com.hackathon.junction.dto

import com.hackathon.junction.entity.OptionValueStatus

data class OptionValueDto(
    val id: Long,
    val value: String,
    val status: OptionValueStatus = OptionValueStatus.USER
)
