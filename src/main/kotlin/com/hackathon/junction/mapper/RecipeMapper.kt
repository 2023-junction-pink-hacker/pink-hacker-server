package com.hackathon.junction.mapper

import com.hackathon.junction.dto.response.SearchRecipeFeedResponse
import com.hackathon.junction.entity.Recipe
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface RecipeMapper {
    fun toSearchRecipeResponse(recipe: Recipe): SearchRecipeFeedResponse
}
