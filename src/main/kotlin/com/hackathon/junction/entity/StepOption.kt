package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class StepOption(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "step_option_id")
    val id: Long? = null,

    @ManyToOne @JoinColumn(name = "step_id")
    val step: Step,

    @ManyToOne @JoinColumn(name = "option_id")
    val option: Option,
)