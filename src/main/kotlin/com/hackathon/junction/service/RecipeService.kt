package com.hackathon.junction.service

import com.hackathon.junction.dto.request.SaveRecipeRequest
import com.hackathon.junction.dto.response.SearchRecipeFeedResponse
import com.hackathon.junction.entity.Recipe
import com.hackathon.junction.entity.RecipeStatus
import com.hackathon.junction.entity.RecipeStep
import com.hackathon.junction.mapper.OptionMapper
import com.hackathon.junction.mapper.RecipeMapper
import com.hackathon.junction.repository.ProductRepository
import com.hackathon.junction.repository.RecipeRepository
import com.hackathon.junction.repository.RecipeStepRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RecipeService(
    private val recipeRepository: RecipeRepository,
    private val recipeStepRepository: RecipeStepRepository,
    private val productRepository: ProductRepository,
    private val optionService: OptionService,
    private val optionMapper: OptionMapper,
    private val recipeMapper: RecipeMapper
) {
    fun searchRecipeByFeed(sort: String): List<SearchRecipeFeedResponse> {
        return recipeRepository.findAllByOrderByCreatedDateDesc()
            .map { recipeMapper.toSearchRecipeResponse(it) }
    }

//    fun searchRecipe

    fun upsertRecipe(saveRecipeRequest: SaveRecipeRequest) {
        with(saveRecipeRequest) {
            // Recipe 저장 및 수정
            val recipe = if (recipeId == null) {
                // Recipe 저장
                val product =
                    productRepository.findById(this.productId).orElseThrow { RuntimeException("productId 가 유효하지 않습니다") }
                Recipe(
                    description,
                    category,
                    product
                )
            } else {
                // Recipe 수정
                val recipe =
                    recipeRepository.findById(this.recipeId).orElseThrow { RuntimeException("recipeId 가 유효하지 않습니다") }
                recipe.copy(
                    description = description,
                    status = RecipeStatus.PUBLIC,
                    imgUrl = imgUrl
                )
            }
            recipeRepository.save(recipe)

            // RecipeStep 저장
            this.steps.map { stepDto ->
                stepDto.options.filter { it.values.isNotEmpty() }.map { optionDto ->
                    RecipeStep(
                        recipeId = recipe.id!!,
                        stepId = stepDto.id,
                        optionValueId = optionDto.values[0].id
                    )
                }
            }.run { recipeStepRepository.saveAll(this.flatten()) }

            // option_value 저장
            this.steps.map { stepDto ->
                val product =
                    productRepository.findById(this.productId).orElseThrow { RuntimeException("productId 가 유효하지 않습니다") }

                stepDto.options.map { optionDto ->
                    val option = optionMapper.toOptionEntity(optionDto, product)
                    val optionValues = optionDto.values.map { optionValueDto ->
                        optionMapper.toOptionValueEntity(optionValueDto, option)
                    }

                    optionService.saveOptionValues(optionValues)
                }
            }
        }
    }
}