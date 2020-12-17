dependencies {
    // Logging
    implementation("ch.qos.logback:logback-classic:${property("logbackVersion")}")

    // Unit Tests
    testImplementation("org.junit.jupiter:junit-jupiter:${property("junitVersion")}")
    testImplementation("org.assertj:assertj-core:${property("assertJVersion")}")
    testImplementation("org.hamcrest:hamcrest:${property("hamcrestVersion")}")
    testImplementation("org.mockito:mockito-core:${property("mockitoVersion")}")
    testImplementation("org.mockito:mockito-junit-jupiter:${property("mockitoVersion")}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

