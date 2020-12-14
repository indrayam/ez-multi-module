plugins {
    id("java-library")
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    // id("org.springframework.boot") version "2.4.0" apply false
}

subprojects {
    group = "me.anandsharma"
    version = "1.0"

    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-library")

    repositories {
        jcenter()
    }

    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11

    dependencyManagement {
        imports {
            // mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.4.0")
        }
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.16")
        annotationProcessor("org.projectlombok:lombok:1.18.16")
    }

}
