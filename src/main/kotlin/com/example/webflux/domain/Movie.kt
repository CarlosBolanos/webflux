package com.example.webflux.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Movie(@Id private val id: String, private val title: String) {
    constructor(title: String) : this(UUID.randomUUID().toString(), title)
}