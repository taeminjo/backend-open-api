package com.nangpun.backend.common

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component

inline fun <reified T> T.logger() = KotlinLogging.logger(T::class.qualifiedName!!)

@Component
class Logger {
    companion object {
        const val TAG = "Logger"
        val LOG = logger()
    }
}