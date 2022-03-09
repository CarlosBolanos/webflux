package com.example.webflux.services

import com.example.webflux.business.MovieRepository
import com.example.webflux.domain.Movie
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class MovieServiceImpl(private val movieRepository: MovieRepository): MovieService {
    override fun getMovieById(id: String): Mono<Movie> {
        return movieRepository.findById(id)
    }

    override fun getAllMovies(): Flux<Movie> {
        return movieRepository.findAll()
    }
}