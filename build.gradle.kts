plugins {
    kotlin("jvm") version "1.3.70"
}

group = "pl.michalperlak"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val kafkaVersion = "2.4.1"
val slf4jVersion = "1.7.28"
val kotlinLoggingVersion = "1.7.8"
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.kafka", "kafka-clients", kafkaVersion)
    implementation("org.slf4j", "slf4j-simple", slf4jVersion)
    implementation("io.github.microutils", "kotlin-logging", kotlinLoggingVersion)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}