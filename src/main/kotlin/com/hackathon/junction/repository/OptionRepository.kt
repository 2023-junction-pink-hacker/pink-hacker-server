package com.hackathon.junction.repository

import com.hackathon.junction.entity.Option
import org.springframework.data.jpa.repository.JpaRepository

interface OptionRepository : JpaRepository<Option, Long> {
}