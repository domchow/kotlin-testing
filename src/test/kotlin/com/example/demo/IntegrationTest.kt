package com.example.demo

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import java.util.*


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

	val PATH = "/customers"

	@Autowired
	lateinit var client: TestRestTemplate

	@Autowired
	lateinit var repository: CustomerRepository

	@Test
	fun getCustomer() {
		val actualCustomer = client.getForEntity(PATH, Array<Customer?>::class.java)
		val expectedCustomer: Optional<Customer> = repository.findById(1L)
		assertThat("Customer name is not as expected", actualCustomer.body!!.get(0)!!.name!!, equalTo(expectedCustomer.get().name!!))
	}
}
