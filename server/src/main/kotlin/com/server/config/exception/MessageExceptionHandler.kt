package com.server.config.exception

import org.springframework.http.HttpStatus
import java.util.Date

class MessageExceptionHandler(
    var timestamp: Date,
    var status: HttpStatus,
    var message: String?
)
