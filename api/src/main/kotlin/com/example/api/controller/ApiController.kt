package com.example.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController {

    @GetMapping
    fun test() = "Hello"
}
