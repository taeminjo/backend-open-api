plugins {
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "2.0.0"
	kotlin("plugin.spring") version "2.0.0"
	kotlin("plugin.jpa") version "2.0.0"
	kotlin("kapt") version "2.0.0"
}

group = "com.nangpun"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// ====#### 기본 ####====
	implementation("org.springframework.boot:spring-boot-starter-web")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	// ====#### validation ####====
	implementation("org.springframework.boot:spring-boot-starter-validation")
	// ====#### Open API ####====
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	// ====#### JPA ####====
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-jdbc")
////	// ====#### security ####====
////	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
////	implementation("org.springframework.boot:spring-boot-starter-security")
//	// ====#### support tool ####====
//	implementation("org.springframework.boot:spring-boot-starter-actuator")
////	//developmentOnly("org.springframework.boot:spring-boot-devtools")
////	// ====#### logging ####====
	implementation("io.github.oshai:kotlin-logging-jvm:6.0.3")
//	implementation("net.logstash.logback:logstash-logback-encoder:7.4")
//// ====##### queryDSL ####====
//	implementation("com.querydsl:querydsl-core:5.0.0")
//	implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
//	kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
////	// ====#### aws ####====
	implementation("software.amazon.awssdk:kms:2.26.16")
	implementation("software.amazon.awssdk:sdk-core:2.26.16")
//	// ====#### RDB(postgresql, mariadb) ####====
//	implementation("org.mariadb.jdbc:mariadb-java-client")
	implementation("org.postgresql:postgresql:42.7.2")
	runtimeOnly("org.postgresql:postgresql")
	// ====##### NoSQL ####====
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
//	// ====##### coroutines ####====
//	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
//	runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.8.0")
//	runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.8.0")
//	// ====#### datadog ####====
//	runtimeOnly("io.micrometer:micrometer-registry-datadog:latest.release")
	// ====#### test ####====
	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("com.ninja-squad:springmockk:4.0.2")
//	testImplementation("io.kotest:kotest-runner-junit5:5.7.2")
//	testImplementation("io.kotest:kotest-assertions-core:5.7.2")
//	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.3")
//	testImplementation("org.springframework.boot:spring-boot-testcontainers")
//	testImplementation("org.testcontainers:junit-jupiter")
//	//testImplementation("org.testcontainers:postgresql:1.19.4")
//	//testImplementation("org.testcontainers:rabbitmq:1.19.4")
//	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
