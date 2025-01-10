plugins {
	id("org.springframework.boot") version "3.2.0" // Usa una versión estable
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("jvm") version "1.9.10"
	kotlin("plugin.spring") version "1.9.10"
	kotlin("plugin.jpa") version "1.9.10"
}

group = "com.server.tecnology"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") } // Solo si usas snapshots
}

dependencies {
	// spring web tools
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Spring Boot Starter para JPA
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// Módulo de Jackson para Kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Reflexión de Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Conector de PostgreSQL
	runtimeOnly("org.postgresql:postgresql")

	// Dependencias de test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.register<Delete>("cleanTemp") {
	delete(file("logs"))
	delete(file("tmp"))
}