package com.hackathon.junction.repository

import com.hackathon.junction.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>