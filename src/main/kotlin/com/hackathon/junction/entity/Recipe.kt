package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
data class Recipe(
    @Column
    val description: String,

    @Column
    val category: String,

    @OneToOne @JoinColumn(name = "product_id")
    val product: Product,

    @Enumerated(EnumType.STRING)
    val status: RecipeStatus = RecipeStatus.PRIVATE,

    @Column(name = "img_url")
    val imgUrl: String? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    val id: Long? = null,
) : BaseTimeEntity()