plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.9.1")
    implementation("org.testng:testng:7.1.0")
    implementation("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
    implementation("org.slf4j:slf4j-simple:2.0.12")
}

tasks.test {
    useTestNG()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}