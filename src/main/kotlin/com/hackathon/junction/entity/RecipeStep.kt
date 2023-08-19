package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class RecipeStep(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_step_id")
    val id: Long? = null,

    @ManyToOne @JoinColumn(name = "recipe_id")
    val recipe: Recipe,

    @ManyToOne @JoinColumn(name = "step_id")
    val step: Step,

    @Column(name = "option_value_id")
    val optionValueId: Long
)