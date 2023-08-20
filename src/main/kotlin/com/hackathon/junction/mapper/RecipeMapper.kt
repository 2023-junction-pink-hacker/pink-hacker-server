package com.hackathon.junction.mapper

import com.hackathon.junction.dto.request.UpdateRecipeRequest
import com.hackathon.junction.dto.response.SearchRecipeFeedResponse
import com.hackathon.junction.entity.Recipe
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface RecipeMapper {
    fun toSearchRecipeResponse(recipe: Recipe): SearchRecipeFeedResponse

    @Mappings(
        Mapping(source = "updateRecipeRequest.imgUrl", target = "imgUrl"),
        Mapping(source = "updateRecipeRequest.description", target = "description"),
        Mapping(source = "updateRecipeRequest.status", target = "status"),
    )
    fun toRecipeEntity(recipe: Recipe, updateRecipeRequest: UpdateRecipeRequest): Recipe
}
