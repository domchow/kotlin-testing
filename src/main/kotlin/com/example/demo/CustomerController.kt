package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController @Autowired constructor(
    val customerService: CustomerService){

    @GetMapping("/customers")
    fun getCustomer(): MutableIterable<Customer> {
        return customerService.getCustomers()
    }
}
