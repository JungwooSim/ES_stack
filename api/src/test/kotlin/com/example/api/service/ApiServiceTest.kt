package com.example.api.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ApiServiceTest(
    @Autowired val apiService: ApiService
) {

    @Test
    fun count() {
        apiService.count()
    }
}