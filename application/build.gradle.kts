plugins {
    id("org.springframework.boot") version "2.4.0"
}

// apply(plugin = "org.springframework.boot")

dependencies {
    implementation(project(":library"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}