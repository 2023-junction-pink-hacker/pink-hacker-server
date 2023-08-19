package com.hackathon.junction.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/test")
    fun test(@Value("\${aws.location}") location: String): Map<String, String> {
        return mapOf("name" to "hue", "age" to "28")
    }
}
