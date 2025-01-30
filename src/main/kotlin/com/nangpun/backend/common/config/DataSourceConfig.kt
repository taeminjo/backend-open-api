package com.nangpun.backend.common.config

import com.nangpun.backend.infrastructure.jpa.ReplicationRoutingDataSource
import com.nangpun.backend.infrastructure.jpa.RoutingDataSourceLookupKey
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import javax.sql.DataSource

@Configuration
@Profile("!test")
class DataSourceConfig {
    @Bean
    @ConfigurationProperties("aws.datasource.write")
    fun writeDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    @ConfigurationProperties("aws.datasource.read")
    fun readDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    fun readDataSource(readDataSourceProperties: DataSourceProperties): DataSource {
        return readDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    fun writeDataSource(writeDataSourceProperties: DataSourceProperties): DataSource {
        return writeDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java)
            .build()
    }

    @DependsOn("readDataSource", "writeDataSource")
    @Bean
    fun routingDataSource(writeDataSource: DataSource, readDataSource: DataSource): DataSource {
        val routingDataSource = ReplicationRoutingDataSource()
        val dataSourceMap = mutableMapOf<Any, Any>()
        dataSourceMap[RoutingDataSourceLookupKey.READ] = readDataSource
        dataSourceMap[RoutingDataSourceLookupKey.WRITE] = writeDataSource
        routingDataSource.setTargetDataSources(dataSourceMap)
        routingDataSource.setDefaultTargetDataSource(readDataSource)
        return routingDataSource
    }

    @DependsOn("routingDataSource")
    @Bean
    fun dataSource(routingDataSource: DataSource): DataSource {
        return LazyConnectionDataSourceProxy(routingDataSource)
    }
}