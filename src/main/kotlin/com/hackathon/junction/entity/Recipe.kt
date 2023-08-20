package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Recipe(
    @Column
    val name: String,

    @Column
    val category: String,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "orderCount")
    val orderCount: Int = 0,

    @Column
    val description: String = "",

    @Enumerated(EnumType.STRING)
    val status: RecipeStatus = RecipeStatus.PRIVATE,

    @Column(name = "img_url")
    val imgUrl: String? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    val id: Long? = null,
) : BaseTimeEntity()