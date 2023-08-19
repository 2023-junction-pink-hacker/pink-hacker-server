package com.hackathon.junction.repository

import com.hackathon.junction.entity.RecipeStep
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeStepRepository : JpaRepository<RecipeStep, Long> {
}