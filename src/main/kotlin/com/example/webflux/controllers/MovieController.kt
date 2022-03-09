package com.example.webflux.controllers

import com.example.webflux.domain.Movie
import com.example.webflux.services.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/movies")
class MovieController(private val movieService: MovieService) {

    @GetMapping
    fun getMovies(): Flux<Movie> {
        val movies = movieService.getAllMovies()

        movies.subscribe{
            println(it)
        }

        return movies
    }

    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: String): Mono<Movie> {
        return movieService.getMovieById(id)
    }
}