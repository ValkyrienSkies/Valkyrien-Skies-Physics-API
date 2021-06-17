plugins {
    kotlin("jvm") version "1.4.21"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
    java
    maven
    checkstyle
}

group = "org.valkyrienskies.physics-api"
version = "1.0"

repositories {
    mavenCentral()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib-jdk8"))

    // JOML for Math
    api("org.joml", "joml", "1.10.0")
    api("org.joml", "joml-primitives", "1.10.0")

    // Guava
    implementation("com.google.guava", "guava", "29.0-jre")

    // FastUtil for Fast Primitive Collections
    implementation("it.unimi.dsi", "fastutil", "8.2.1")

    // Junit 5 for Unit Testing
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.4.2")

    // LWJGL for Test Suites
    // LWJGL platforms are defined here https://github.com/LWJGL/lwjgl3/blob/161ca91dd9289fd7c1da4f420f10ff472f8671c7/build.gradle.kts#L61-L74
    val lwjglPlatforms = arrayOf(
        null,
        "natives-linux",
        "natives-linux-arm64",
        "natives-linux-arm32",
        "natives-macos",
        // "natives-macos-arm64", // Rip
        "natives-windows",
        "natives-windows-x86"
        // "natives-windows-arm64" // Rip
    )
    val lwjglVersion = "3.2.3"
    for (platform in lwjglPlatforms) {
        testImplementation("org.lwjgl", "lwjgl", version = lwjglVersion, classifier = platform)
        testImplementation("org.lwjgl", "lwjgl-glfw", version = lwjglVersion, classifier = platform)
        testImplementation("org.lwjgl", "lwjgl-opengl", version = lwjglVersion, classifier = platform)
    }
}

tasks.withType<Checkstyle> {
    reports {
        // Do not output html reports
        html.isEnabled = false
        // Output xml reports
        xml.isEnabled = true
    }
}

checkstyle {
    toolVersion = "8.41"
    configFile = file("$rootDir/.checkstyle/checkstyle.xml")
    isIgnoreFailures = false
}

ktlint {
    disabledRules.set(setOf("parameter-list-wrapping"))
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    compileTestJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}
