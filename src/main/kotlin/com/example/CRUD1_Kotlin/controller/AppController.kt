package com.example.CRUD1_Kotlin.controller


import com.example.CRUD1_Kotlin.entity.Product
import com.example.CRUD1_Kotlin.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView


@Controller
class AppController {
    @Autowired
    private lateinit var service: ProductService

    @RequestMapping("/")
    fun viewHomePage(model: Model):String{
        val listProducts = service.listAll()
        model.addAttribute("listProducts", listProducts)

        return "index"
    }

    @RequestMapping("/new")
    fun showNewProductPage(model: Model): String? {
        val product = Product()
        model.addAttribute("product", product)
        return "new_product"
    }

    @RequestMapping(value = ["/save"], method = [RequestMethod.POST])
    fun saveProduct(@ModelAttribute("product") product: Product?): String? {
        service.save(product!!)
        return "redirect:/"
    }

    @RequestMapping("/edit/{id}")
    fun showEditProductPage(@PathVariable(name = "id") id: Int): ModelAndView? {
        val mav = ModelAndView("edit_product")
        val product = service.get(id.toLong())
        mav.addObject("product", product)
        return mav
    }

    @RequestMapping("/delete/{id}")
    fun deleteProduct(@PathVariable(name = "id") id: Int): String? {
        service.delete(id.toLong())
        return "redirect:/"
    }
}