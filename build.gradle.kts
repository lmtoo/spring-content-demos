plugins {
    java
    kotlin("jvm") version "1.3.60"
    id("org.springframework.boot") version "2.2.1.RELEASE"
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
    implementation("org.hsqldb:hsqldb:2.5.0")
    implementation("org.hibernate:hibernate-entitymanager:5.4.9.Final")

    implementation("com.github.paulcwarren:spring-content-fs-boot-starter:1.0.0.M3")
    implementation("com.github.paulcwarren:spring-content-rest-boot-starter:1.0.0.M3"){
        exclude("org.springframework.boot", "spring-boot-dependencies")
    }
    implementation("com.github.paulcwarren:spring-versions-jpa-boot-starter:1.0.0.M3"){
        exclude("org.springframework.boot", "spring-boot-dependencies")
    }

    implementation("org.springframework.boot:spring-boot-starter-data-rest:2.2.1.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.1.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.1.RELEASE")
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