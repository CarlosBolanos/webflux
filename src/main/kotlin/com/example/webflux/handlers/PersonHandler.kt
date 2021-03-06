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
        val persons = personService.get()
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(persons)
    }

    fun getById(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id").toInt()
        val person = personService.getById(id)
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(person)
    }
}
