package com.hackathon.junction.controller

import com.hackathon.junction.dto.response.SearchStepsResponse
import com.hackathon.junction.service.StepService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RecipeController(private val stepService: StepService) {

    @GetMapping("/steps/products/{productId}")
    fun searchSteps(@PathVariable productId: Long): SearchStepsResponse {
        val steps = stepService.getStepsByProductId(productId)
        return SearchStepsResponse(productId, steps)
    }
}