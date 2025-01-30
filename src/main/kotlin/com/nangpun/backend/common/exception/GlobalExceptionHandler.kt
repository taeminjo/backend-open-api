package com.nangpun.backend.common.exception

import org.springframework.web.bind.annotation.RestControllerAdvice

//@RestControllerAdvice
class GlobalExceptionHandler {
//    @ExceptionHandler(UnsupportedJwtException::class)
//    fun handle(message: String, ex: Exception?): ResponseDTO<Void?>? {
//        //TODO: log format 정의 필요
//        LogKotlin.LOG.logger.error("Jwt Exception Error ======== " + ex!!.stackTraceToString(), ex)
//        Sentry.captureException(ex)
//        return ResponseDTO(ResponseCode.AUTH_FAILED)
//    }
}