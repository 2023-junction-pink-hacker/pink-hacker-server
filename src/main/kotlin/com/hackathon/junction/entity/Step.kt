package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Step(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "step_id")
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val position: Int,

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "product_id")
    val product: Product,
)