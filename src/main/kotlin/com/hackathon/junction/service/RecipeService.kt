package com.hackathon.junction.service

import com.hackathon.junction.repository.ProductRepository
import com.hackathon.junction.repository.StepRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RecipeService(
    private val stepRepository: StepRepository,
    private val stepProductRepository: ProductRepository
) {
}