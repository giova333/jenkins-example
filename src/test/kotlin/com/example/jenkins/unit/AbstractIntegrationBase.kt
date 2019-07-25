package com.example.jenkins.unit

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@Sql(scripts = ["classpath:/tearDown.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
abstract class AbstractIntegrationBase