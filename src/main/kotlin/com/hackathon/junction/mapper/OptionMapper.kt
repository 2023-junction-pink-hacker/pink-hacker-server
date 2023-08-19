package com.hackathon.junction.mapper

import com.hackathon.junction.dto.OptionDto
import com.hackathon.junction.dto.OptionValueDto
import com.hackathon.junction.entity.Option
import com.hackathon.junction.entity.OptionValue
import com.hackathon.junction.entity.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface OptionMapper {

    fun toOptionDto(option: Option, values: List<OptionValueDto>): OptionDto

    fun toOptionValueDto(optionValue: OptionValue): OptionValueDto

    @Mappings(
        Mapping(source = "optionDto.id", target = "id"),
    )
    fun toOptionEntity(optionDto: OptionDto, product: Product): Option


    @Mappings(
        Mapping(source = "id", target = "id"),
    )
    fun toOptionValueEntity(optionValueDto: OptionValueDto, option: Option, id: Long? = null): OptionValue
}
