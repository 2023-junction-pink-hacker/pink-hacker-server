package com.hackathon.junction.controller

import com.hackathon.junction.dto.request.SaveRecipeRequest
import com.hackathon.junction.dto.request.UpdateRecipeRequest
import com.hackathon.junction.dto.response.SearchRecipeFeedResponse
import com.hackathon.junction.dto.response.SearchStepsResponse
import com.hackathon.junction.service.RecipeService
import com.hackathon.junction.service.StepService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RecipeController(
    private val stepService: StepService,
    private val recipeService: RecipeService
) {

    @GetMapping("/steps/products/{productId}")
    fun searchSteps(@PathVariable productId: Long): SearchStepsResponse {
        val steps = stepService.getStepsByProductId(productId)
        return SearchStepsResponse(productId, steps)
    }

    @PostMapping("/recipes")
    fun saveRecipe(@RequestBody saveRecipeRequest: SaveRecipeRequest): String {
        recipeService.saveRecipe(saveRecipeRequest)
        return "OK"
    }

    @PutMapping("/recipes")
    fun updateRecipe(@RequestBody updateRecipeRequest: UpdateRecipeRequest): String {
        recipeService.updateRecipe(updateRecipeRequest)
        return "OK"
    }

    @GetMapping("/recipes/feed")
    fun searchRecipeByFeed(
        @RequestParam(defaultValue = "popular", required = false) sort: String
    ): List<SearchRecipeFeedResponse> {
        // TODO: 주문수 필드 추가
        return recipeService.searchRecipeByFeed(sort)
    }

//    @GetMapping("/recipes/{recipeId}")
//    fun searchRecipe(
//        @PathVariable recipeId: Long
//    ) {
//        return recipeService.searchRecipe(recipeId)
//    }
}