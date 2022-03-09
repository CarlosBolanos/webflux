package com.example.webflux.business

import com.example.webflux.domain.Movie
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MovieRepository: ReactiveMongoRepository<Movie, String>