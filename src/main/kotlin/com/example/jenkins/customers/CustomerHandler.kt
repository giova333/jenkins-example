package com.example.jenkins.customers

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

class CustomerHandler(private var repository: CustomerRepository) {

    fun save(request: ServerRequest) =
            ServerResponse.ok().body(
                    request.bodyToMono(Customer::class.java)
                            .flatMap { repository.save(it) },
                    Customer::class.java
            )

    fun findAll(request: ServerRequest) =
            ServerResponse.ok().body(repository.findAll(), Customer::class.java)
}