
plugins {
    id("java")
}

group = "org.elaleksap"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.21.0")
    implementation("io.github.bonigarcia:webdrivermanager:6.1.0")

    testImplementation("org.testng:testng:7.10.2")

    implementation("org.slf4j:slf4j-api:2.0.12")
    implementation("ch.qos.logback:logback-classic:1.5.6")
}

tasks.test {
    useTestNG()
}

