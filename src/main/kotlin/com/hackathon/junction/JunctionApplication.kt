package com.hackathon.junction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class JunctionApplication

fun main(args: Array<String>) {
    runApplication<JunctionApplication>(*args)
}
