//apply(plugin = "org.springframework.boot")

plugins {
    application
}

val theMain by extra("me.anandsharma.HelloWorld")

application {
    mainClass.set(theMain)
}

dependencies {
    implementation(project(":library"))

    // Bootiful stuff...

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

tasks.jar {
    manifest {
        attributes(
            "Implementation-Title" to "Gradle",
            "Implementation-Version" to archiveVersion,
            "Main-Class" to theMain
        )
    }
}

tasks.register<Jar>("uberJar") {
    archiveClassifier.set("uber")
    manifest {
        attributes(
            "Implementation-Title" to "Gradle",
            "Implementation-Version" to archiveVersion,
            "Main-Class" to theMain
        )
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}