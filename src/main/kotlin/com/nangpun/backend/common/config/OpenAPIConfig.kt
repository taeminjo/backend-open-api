package com.nangpun.backend.common.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@OpenAPIDefinition
@Configuration
@Profile("dev","local")
class OpenAPIConfig {
    @Bean
    fun customOpenAPI(@Value("\${openapi.service.url}") url: String?): OpenAPI {
        return OpenAPI()
            .servers(listOf(Server().url(url)))
            .components(
                Components().addSecuritySchemes(
                    "Bearer",
                    SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                )
            )
            .addSecurityItem(SecurityRequirement().addList("Bearer"))
            .info(
                Info().title("Kotlin 표준 API(DDD 방식 적용)")
                    .description("")
                    .version("v1")
            )
    }
}