package com.example.jenkins.customers

import org.springframework.web.reactive.function.server.router

class CustomerRoutes(private val handler: CustomerHandler) {
    fun routes() = router {
        "/customers".nest {
            GET("/", handler::findAll)
            POST("/", handler::save)
        }
    }
}