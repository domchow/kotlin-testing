package com.example.demo

import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController @Autowired constructor(
    val customerService: CustomerService
) {

    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "...", content = [
                    (Content(
                        mediaType = "application/json", array = (
                                ArraySchema(schema = Schema(implementation = Customer::class)))
                    ))]
            )]
    )
    @GetMapping("/customers")
    fun getCustomer(): MutableIterable<Customer> {
        return customerService.getCustomers()
    }
}
