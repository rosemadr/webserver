plugins {
    kotlin("jvm") version "2.4.20"
    application
}

group = "com.example.project"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // Testing dependencies
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

application {
    mainClass.set("com.example.project.ApplicationKt")
}

tasks.test {
    useJUnitPlatform()
}