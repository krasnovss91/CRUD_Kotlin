package com.example.CRUD1_Kotlin.repository;

import com.example.CRUD1_Kotlin.entity.Product
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository : JpaRepository<Product, Long> {
}