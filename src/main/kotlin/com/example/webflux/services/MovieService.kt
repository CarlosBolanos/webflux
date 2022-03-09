package com.example.webflux.services

import com.example.webflux.domain.Movie
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MovieService {
    fun getMovieById(id: String): Mono<Movie>
    fun getAllMovies(): Flux<Movie>
}