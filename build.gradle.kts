import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.asciidoctor.convert") version "1.5.8"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
	kotlin("plugin.jpa") version "1.5.21"
}

group = "com.example.com.example.cleanArchitecture"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {


	//SEGURANCA
	//implementation("org.springframework.boot:spring-boot-starter-security")

	//VALIDATION
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation(project(":web"))
	implementation(project(":repository"))


	//KOTLIN
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.4")

	//implementation("io.springfox:springfox-swagger2:2.9.2")
	//implementation("io.springfox:springfox-swagger-ui:2.9.2")
	//implementation("org.springframework.boot:spring-boot-starter-parent:2.4.0")
	//implementation("io.springfox:springfox-boot-starter:3.0.0")
	//implementation("org.springframework.boot:spring-boot-starter-data-rest:2.5.4")
	//implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")




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




allprojects {
	group = "com.example.com.example.cleanArchitecture"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<JavaCompile> {
		sourceCompatibility = "1.8"
		targetCompatibility = "1.8"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}

}



subprojects {
	group = "com.example.cleanArchitecture"
	version = "0.0.2-SNAPSHOT"
	repositories {
		mavenCentral()
		mavenLocal()
	}

	apply {
		plugin("java")
		plugin("kotlin")
		plugin("kotlin-allopen")
		plugin("io.spring.dependency-management")
	}

	sourceSets {
		//main.java.srcDirs += "src/main/kotlin"
	}

	allOpen {
		annotation("org.springframework.stereotype.Component")
		annotation("org.springframework.stereotype.Service")
		annotation("org.springframework.stereotype.Repository")
		annotation("org.springframework.stereotype.Configuration")
		annotation("org.springframework.stereotype.ComponentScan")

	}

}