plugins {
    java
    kotlin("jvm") version "1.3.72"
    id("org.springframework.boot") version "2.3.4.RELEASE"
}

group = "cn.lmtoo.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://repo.spring.io/milestone/")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
//    implementation("org.hsqldb:hsqldb:2.5.0")
    implementation("mysql:mysql-connector-java:8.0.18")

    implementation("com.github.paulcwarren:spring-content-fs-boot-starter:1.1.0.M3")
    implementation("com.github.paulcwarren:spring-content-rest-boot-starter:1.1.0.M3") {
        exclude("org.springframework.boot", "spring-boot-dependencies")
    }
    implementation("com.github.paulcwarren:spring-versions-jpa-boot-starter:1.1.0.M3") {
        exclude("org.springframework.boot", "spring-boot-dependencies")
    }

    implementation("org.springframework.boot:spring-boot-starter-data-rest:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE")
//    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

task<Exec>("gitbook-init") {
    commandLine("gitbook", "init")
}

task<Exec>("gitbook-build") {
    commandLine("gitbook", "build")
}