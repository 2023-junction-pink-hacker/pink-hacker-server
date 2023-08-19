package com.hackathon.junction.repository

import com.hackathon.junction.entity.StepOption
import org.springframework.data.jpa.repository.JpaRepository

interface StepOptionRepository : JpaRepository<StepOption, Long> {
    fun findAllByStepId(stepId: Long): List<StepOption>
}