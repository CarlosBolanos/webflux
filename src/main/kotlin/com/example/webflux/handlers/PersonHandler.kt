package com.example.webflux.handlers

import com.example.webflux.business.PersonRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class PersonHandler {

    @Autowired
    lateinit var personService: PersonRepositoryImpl

    fun getAll(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(personService.get())
    }

    fun getById(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id").toInt()
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(personService.getById(id))
    }
}
