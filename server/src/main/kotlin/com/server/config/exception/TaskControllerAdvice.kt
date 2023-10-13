package com.server.config.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@ControllerAdvice
class TaskControllerAdvice {

    @ResponseBody
    @ExceptionHandler
    fun taskNotFound(
        taskNotFoundException: TaskNotFoundException
    ): ResponseEntity<MessageExceptionHandler> {
        val error = MessageExceptionHandler(Date(), HttpStatus.NOT_FOUND, taskNotFoundException.message);
        return ResponseEntity<MessageExceptionHandler>(error, HttpStatus.NOT_FOUND)
    }

    @ResponseBody
    @ExceptionHandler
    fun taskBadRequest(
        taskBadRequest: TaskBadRequest,
    ): ResponseEntity<MessageExceptionHandler> {
        val error = MessageExceptionHandler(Date(), HttpStatus.BAD_REQUEST, taskBadRequest.message);
        return ResponseEntity<MessageExceptionHandler>(error, HttpStatus.BAD_REQUEST)
    }
}