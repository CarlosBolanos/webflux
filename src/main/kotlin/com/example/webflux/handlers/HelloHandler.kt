package com.example.webflux.handlers

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class HelloHandler {
    fun hello(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .body(Mono.just("Hello World"))
    }
}
