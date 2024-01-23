plugins {
    kotlin("jvm") version "1.9.21"
    id("maven-publish")
}

group = "com.github.pavlovvladimir"
version = "0.0.3"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("mavenRelease") {
            artifactId = "funk"
            from(components["kotlin"])
        }
    }
}