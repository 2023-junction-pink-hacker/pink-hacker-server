package com.hackathon.junction.repository

import com.hackathon.junction.entity.OptionValue
import com.hackathon.junction.entity.OptionValueStatus
import org.springframework.data.jpa.repository.JpaRepository

interface OptionValueRepository : JpaRepository<OptionValue, Long> {
    fun findByOptionIdAndStatus(optionId: Long, status: OptionValueStatus): List<OptionValue>
}