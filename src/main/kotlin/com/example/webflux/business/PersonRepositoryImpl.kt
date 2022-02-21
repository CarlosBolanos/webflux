package com.example.webflux.business

import com.example.webflux.domain.Person
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PersonRepositoryImpl : PersonRepository {

    private var person1 = Person(1, "carlos", "bolanos")
    private var person2 = Person(2, "raul", "bolanos")
    private var person3 = Person(3, "esperanza", "rodriguez")

    override fun getById(id: Int): Mono<Person> = Mono.just(person1)
    override fun get(): Flux<Person> = Flux.just(person1, person2, person3)
}
