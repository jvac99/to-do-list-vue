package com.server.models

import jakarta.persistence.*
import java.util.UUID

enum class Status {
    BACKLOG, DO, DOING, DONE
}

enum class Priority {
    LOW, MEDIUM, HIGH
}

@Entity
@Table
data class Task(
    var title: String,
    var description: String,
    var status: Status,
    var priority: Priority,
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID? = null
)