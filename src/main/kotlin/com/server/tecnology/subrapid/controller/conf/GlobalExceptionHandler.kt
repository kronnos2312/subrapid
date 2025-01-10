package com.server.tecnology.subrapid.controller.conf

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<Map<String, Any>> {
        val body = mapOf<String, Any>(
            "timestamp" to System.currentTimeMillis(),
            "message" to (ex.message ?: "Unknown error"),
            "details" to ex.stackTraceToString()
        )
        return ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
