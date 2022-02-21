package com.example.webflux.business

import com.example.webflux.domain.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

class PersonRepositoryImplTest {

    lateinit var personService: PersonRepositoryImpl

    @BeforeEach
    fun setup(){
        personService = PersonRepositoryImpl()
    }

    @Test
    fun getByIdBlock() {
        val personMono = personService.getById(1)
        val person = personMono.block()

        assertEquals(person?.id, 1)
        assertEquals(person?.firstName, "carlos")
        assertEquals(person?.lastName, "bolanos")
    }

    @Test
    fun getByIdSubscribe() {
        val personMono = personService.getById(1)

        StepVerifier.create(personMono)
            .expectNext(Person(1, "carlos", "bolanos"))
            .verifyComplete()
    }

    @Test
    fun getAllBlock() {
        val personsFlux = personService.get()
        val firstPerson = personsFlux.blockFirst()
        val lastPerson = personsFlux.blockLast()

        assertEquals(firstPerson?.id, 1)
        assertEquals(firstPerson?.firstName, "carlos")
        assertEquals(firstPerson?.lastName, "bolanos")

        assertEquals(lastPerson?.id, 3)
        assertEquals(lastPerson?.firstName, "esperanza")
        assertEquals(lastPerson?.lastName, "rodriguez")
    }

    @Test
    fun getAllSubscribe() {
        StepVerifier.create(personService.get())
            .expectNextCount(3)
            .verifyComplete()
    }

    @Test
    fun testFindPersonById(){
        var personMono = personService.get().filter{ it.id == 1}.single()

        var test = StepVerifier.create(personMono)
        test.expectNext(Person(1, "carlos", "bolanos")).verifyComplete()

        personMono = personService.get().filter{ it.id == 3}.single()
        test = StepVerifier.create(personMono)

        test.expectNext(Person(3, "esperanza", "rodriguez")).verifyComplete()
    }
}
