package com.server.config.exception

class TaskBadRequest(override var message: String = "Invalid Request") : RuntimeException();