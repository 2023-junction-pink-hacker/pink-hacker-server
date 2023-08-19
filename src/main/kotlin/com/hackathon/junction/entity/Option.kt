package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "options")
data class Option(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "options_id")
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    val type: OptionType,

    @Column
    val title: String,

    @ManyToOne @JoinColumn(name = "product_id")
    val product: Product,
)