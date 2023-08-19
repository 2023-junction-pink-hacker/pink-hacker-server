package com.hackathon.junction.service

import com.hackathon.junction.dto.StepDto
import com.hackathon.junction.repository.StepRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StepService(
    private val stepRepository: StepRepository,
    private val optionService: OptionService
) {
    fun getStepsByProductId(productId: Long) = stepRepository.findAllByProductId(productId)
        .map { step ->
            val optionDtoList = optionService.getOptionsByStepId(step.id!!)
            StepDto(
                id = step.id!!,
                name = step.name,
                position = step.position,
                options = optionDtoList
            )
        }
}