package com.hackathon.junction.repository

import com.hackathon.junction.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository : JpaRepository<Recipe, Long> {
    fun findAllByOrderByCreatedDateDesc(): List<Recipe>

    fun findAllByOrderByOrderCountDesc(): List<Recipe>
}