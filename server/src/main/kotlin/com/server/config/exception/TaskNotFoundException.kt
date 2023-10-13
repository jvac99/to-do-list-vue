package com.server.config.exception

class TaskNotFoundException(override var message: String = "Task not found") : RuntimeException();