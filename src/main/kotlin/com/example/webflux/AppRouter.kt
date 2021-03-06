package com.example.webflux

import com.example.webflux.business.MovieRepository
import com.example.webflux.handlers.HelloHandler
import com.example.webflux.handlers.MovieHandler
import com.example.webflux.handlers.PersonHandler
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router

@Component
class AppRouter(private val movieRepository: MovieRepository) {

    @Bean
    fun helloRoutes(handler: HelloHandler): RouterFunction<ServerResponse> = router {
        ("/hello" and accept(MediaType.APPLICATION_JSON))
            .nest {
                GET(handler::hello)
            }
    }

    @Bean
    fun personRoutes(handler: PersonHandler): RouterFunction<ServerResponse> = router {
        ("/persons" and accept(MediaType.APPLICATION_JSON))
            .nest {
                GET( "/all", handler::getAll)
                GET("/{id}", handler::getById)
            }
    }

//    @Bean
//    fun moviesRoutes(handler: MovieHandler): RouterFunction<ServerResponse> = router {
//        ("/movies" and accept(MediaType.APPLICATION_JSON))
//            .nest {
//                GET( "/all", handler::getAll)
//                GET("/{id}", handler::getById)
//            }
//    }
}
