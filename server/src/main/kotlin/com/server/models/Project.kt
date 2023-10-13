package com.server.models

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table
data class Project (
    var name: String,
    var author: String,
    var creationDate: LocalDate,
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID? = null
);