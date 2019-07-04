package com.example.jenkins.customers

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("customers")
data class Customer(@Id val id: Long, var name: String)