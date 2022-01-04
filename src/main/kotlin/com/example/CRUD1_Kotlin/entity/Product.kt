package com.example.CRUD1_Kotlin.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "product")
@Entity
open class Product {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name")
    open var name: String? = null

    @Column(name = "made_in")
    open var madeIn: String? = null

    @Column(name = "price")
    open var price: Double? = null
}