package com.nangpun.backend


import com.nangpun.backend.common.Logger
import com.nangpun.backend.common.logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
	Logger.LOG.logger().info { "Test" }
	runApplication<BackendApplication>(*args)
	// http://localhost:18184/backend-service/swagger-ui/swagger-ui/index.html
}
