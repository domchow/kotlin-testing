package com.example.demo

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitTest {

    @Mock
    lateinit var customerService: CustomerService

    @InjectMocks
    lateinit var customerController: CustomerController

    @Test
    fun getCustomer() {
        val name = "Anna"
        `when`(customerService.getCustomers())
            .thenReturn(mutableListOf(Customer(1, name, "Hellofresh")))
        val result: MutableIterable<Customer> = customerController.getCustomer()
        result.forEach { assertThat("Customer name is not as expected", it.name, equalTo("name")) }
    }
}
