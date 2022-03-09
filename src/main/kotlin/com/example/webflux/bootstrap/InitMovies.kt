package com.example.webflux.bootstrap

import com.example.webflux.business.MovieRepository
import com.example.webflux.domain.Movie
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class InitMovies(private val movieRepository: MovieRepository) :CommandLineRunner {

    override fun run(vararg args: String?) {
        movieRepository.run {
            deleteAll()
                .thenMany(
                    Flux.just("my movie 1", "my movie 2", "my movie 3")
                        .map { Movie(title = it) }
                        .flatMap(this::save)
                )
        }
    }
}