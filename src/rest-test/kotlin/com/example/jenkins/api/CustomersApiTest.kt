package com.example.jenkins.api

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class CustomersApiTest {

    private val url = "http://localhost:8081/customers"

    @Test
    fun `End 2 End Api Test`() {
        given()
                .`when`()
                .get(url)
                .then()
                .assertThat().statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body("size()", `is`(3))
                .body("get(0).name", equalTo("Alex"))
                .body("get(1).name", equalTo("Dean"))
                .body("get(2).name", equalTo("Sam"))
    }
}