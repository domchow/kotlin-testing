package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService @Autowired constructor(
    val repository: CustomerRepository
) {
    fun getCustomers(): MutableIterable<Customer> {
        return repository.findAll();
    }
}
