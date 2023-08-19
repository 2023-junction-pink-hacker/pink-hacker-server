package com.hackathon.junction.repository

import com.hackathon.junction.entity.Step
import org.springframework.data.jpa.repository.JpaRepository

interface StepRepository : JpaRepository<Step, Long>