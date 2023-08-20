package com.hackathon.junction.repository

import com.hackathon.junction.entity.Recipe
import com.hackathon.junction.entity.RecipeStatus
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository : JpaRepository<Recipe, Long> {
    fun findAllByOrderByCreatedDateDesc(): List<Recipe>

    fun findAllByOrderByOrderCountDesc(): List<Recipe>

    fun findAllByStatus(status: RecipeStatus = RecipeStatus.PRIVATE): List<Recipe>
}