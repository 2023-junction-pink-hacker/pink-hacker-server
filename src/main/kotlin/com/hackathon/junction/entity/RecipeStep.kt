package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class RecipeStep(
    @Column(name = "recipe_id")
    val recipeId: Long,

    @Column(name = "step_id")
    val stepId: Long,

    @Column(name = "option_value_id")
    val optionValueId: Long,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_step_id")
    val id: Long? = null,
)