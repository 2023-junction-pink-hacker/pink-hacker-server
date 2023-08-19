package com.hackathon.junction.repository

import com.hackathon.junction.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long> {
}