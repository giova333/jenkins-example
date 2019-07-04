package com.example.jenkins

import com.example.jenkins.customers.CustomerHandler
import com.example.jenkins.customers.CustomerRoutes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

@SpringBootConfiguration
@EnableAutoConfiguration
class JenkinsApplication {
    @Autowired
    fun register(ctx: GenericApplicationContext) = beans().initialize(ctx)

    fun beans() = beans {
        bean<CustomerHandler>()
        bean {
            CustomerRoutes(ref()).routes()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<JenkinsApplication>(*args)
}
