plugins {
    id("java")
    id("org.springframework.boot") version "2.4.1" apply false
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.spring.dependency-management")

    group = "me.anandsharma"
    version = "1.0"
    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11

    repositories {
        jcenter()
    }

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.16")
        annotationProcessor("org.projectlombok:lombok:1.18.16")
    }

}
