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

@Entity
class OptionValue(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_value_id")
    val id: Long? = null,

    @Column
    val value: String,

    @ManyToOne @JoinColumn(name = "option_id")
    val option: Option,

    @Enumerated(EnumType.STRING)
    val status: OptionValueStatus
)