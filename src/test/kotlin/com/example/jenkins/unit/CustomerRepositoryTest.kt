package com.example.jenkins.unit

import com.example.jenkins.customers.Customer
import com.example.jenkins.customers.CustomerRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import reactor.test.StepVerifier

class CustomerRepositoryTest(@Autowired val repository: CustomerRepository) : AbstractIntegrationBase() {

    @Test
    fun `Should return Alex Dean and Sam`() {
        StepVerifier
                .create(repository.findAll())
                .expectNext(Customer(1, "Alex"))
                .expectNext(Customer(2, "Dean"))
                .expectNext(Customer(3, "Sam"))
                .verifyComplete()
    }
}