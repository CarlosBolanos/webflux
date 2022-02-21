package com.example.webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(value = arrayOf("com.example.webflux"))
class WebfluxApplication

fun main(args: Array<String>) {
    runApplication<WebfluxApplication>(*args)
}
