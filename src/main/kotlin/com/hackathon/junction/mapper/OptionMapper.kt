package com.hackathon.junction.mapper

import com.hackathon.junction.dto.OptionDto
import com.hackathon.junction.dto.OptionValueDto
import com.hackathon.junction.entity.Option
import com.hackathon.junction.entity.OptionValue
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface OptionMapper {

    fun toOptionDto(option: Option, values: List<OptionValueDto>): OptionDto

    fun toOptionValueDto(optionValue: OptionValue): OptionValueDto

//    fun toConsumerCommand(consumerEntity: ConsumerEntity): ConsumerCommand

//    @Mappings(
//        Mapping(source = "workUser", target = "createdBy"),
//        Mapping(source = "workUser", target = "lastModifiedBy"),
//    )
//    fun toConsumerEntity(consumerRequestCommand: ConsumerRequestCommand): ConsumerEntity
}
