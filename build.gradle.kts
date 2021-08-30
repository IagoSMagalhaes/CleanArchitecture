import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.asciidoctor.convert") version "1.5.8"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
	kotlin("plugin.jpa") version "1.5.21"
}

group = "com.example.cleanArchitecture"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")

	//implementation("org.postgresql:postgresql:9.4-1200-jdbc4")

	//implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")


	//Swagger
	implementation("org.springframework.boot:spring-boot-starter-parent:2.4.0")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation("io.springfox:springfox-swagger2:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")


	//Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	//testImplementation("org.springframework.security:spring-security-test")



}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
