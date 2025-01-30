package com.nangpun.backend.common.config


import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
@Profile("!test")
class JpaConfig {
    private fun createEntityManagerFactoryBuilder(jpaProperties: JpaProperties): EntityManagerFactoryBuilder {
        val jpaVendorAdapter = createJpaVendorAdapter(jpaProperties)
        return EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties.properties, null)
    }

    private fun createJpaVendorAdapter(jpaProperties: JpaProperties): JpaVendorAdapter {
        val hibernateJpaVendorAdapter = HibernateJpaVendorAdapter()
        hibernateJpaVendorAdapter.setGenerateDdl(true)
        hibernateJpaVendorAdapter.setShowSql(true)

        jpaProperties.properties["hibernate.physical_naming_strategy"] =
            "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy"
        jpaProperties.properties["hibernate.implicit_naming_strategy"] =
            "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy"
//        jpaProperties.properties["hibernate.hbm2ddl.auto"] = "create"

        return HibernateJpaVendorAdapter()
    }

    @Bean
    fun entityManagerFactory(
        dataSource: DataSource,
        jpaProperties: JpaProperties,
    ): LocalContainerEntityManagerFactoryBean {
        val builder = createEntityManagerFactoryBuilder(jpaProperties)
        return builder.dataSource(dataSource)
            .packages("com.nangpun.backend")
            .build()
    }

    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory
        return transactionManager
    }
}