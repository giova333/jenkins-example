package com.example.jenkins.customers

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.http.HttpHeaders
import org.springframework.test.web.reactive.server.WebTestClient

@AutoConfigureWebTestClient
class ApiTest(@Autowired private val client: WebTestClient) : AbstractIntegrationBase() {

    private val uri = "/customers"

    @Test
    fun `Should return Alex Dean and Sam`() {
        client.get()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .json("""
                    [
                       {
                          "id":1,
                          "name":"Alex"
                       },
                       {
                          "id":2,
                          "name":"Dean"
                       },
                       {
                          "id":3,
                          "name":"Sam"
                       }
                    ]
                """)
    }

}