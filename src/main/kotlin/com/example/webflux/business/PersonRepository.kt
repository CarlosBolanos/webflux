package com.example.webflux.business

import com.example.webflux.domain.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

public interface PersonRepository {
    fun getById(id: Int): Mono<Person>
    fun get(): Flux<Person>
}
