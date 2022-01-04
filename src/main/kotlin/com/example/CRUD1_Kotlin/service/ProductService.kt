package com.example.CRUD1_Kotlin.service

import com.example.CRUD1_Kotlin.entity.Product
import com.example.CRUD1_Kotlin.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductService {

    @Autowired
    private lateinit var repository: ProductRepository

    fun listAll():List<Product>{
       return repository.findAll()
    }

    fun save(product: Product):Unit{
        repository.save(product)
    }

    fun get(id:Long):Product{
        return repository.findById(id).get()
    }

    fun delete(id:Long):Unit{
        repository.deleteById(id)
    }

}