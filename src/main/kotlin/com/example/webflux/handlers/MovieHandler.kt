package com.example.webflux.handlers

import com.example.webflux.services.MovieService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class MovieHandler(private val movieService: MovieService) {

    fun getById(serverRequest: ServerRequest): Mono<ServerResponse> {
        val movie = movieService.getMovieById(serverRequest.pathVariable("id"))

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(movie)
    }

    fun getAll(serverRequest: ServerRequest): Mono<ServerResponse> {
       val movies = this.movieService.getAllMovies()

        movies.subscribe{println(it)}

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(movies)
    }
}

