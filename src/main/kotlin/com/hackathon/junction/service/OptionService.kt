package com.hackathon.junction.service

import com.hackathon.junction.dto.OptionDto
import com.hackathon.junction.mapper.OptionMapper
import com.hackathon.junction.repository.OptionRepository
import com.hackathon.junction.repository.OptionValueRepository
import com.hackathon.junction.repository.StepOptionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OptionService(
    private val optionRepository: OptionRepository,
    private val optionValueRepository: OptionValueRepository,
    private val optionMapper: OptionMapper,
    private val stepOptionRepository: StepOptionRepository
) {
    fun getOptionWithValues(optionIds: List<Long>): List<OptionDto> {
        return optionRepository.findAllByIdIn(optionIds)
            .map { option ->
                val optionValueDtoList = optionValueRepository.findByOptionId(option.id!!)
                    .map { optionMapper.toOptionValueDto(it) }
                optionMapper.toOptionDto(option, optionValueDtoList)
            }
    }

    fun getOptionsByStepId(stepId: Long): List<OptionDto> {
        val optionsIds = stepOptionRepository.findAllByStepId(stepId).map { it.option.id as Long }
        return getOptionWithValues(optionsIds)
    }
}