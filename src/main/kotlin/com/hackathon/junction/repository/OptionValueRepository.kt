package com.hackathon.junction.repository

import com.hackathon.junction.entity.OptionValue
import org.springframework.data.jpa.repository.JpaRepository

interface OptionValueRepository : JpaRepository<OptionValue, Long>