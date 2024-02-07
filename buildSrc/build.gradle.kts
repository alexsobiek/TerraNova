plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation("com.github.johnrengelman:shadow:8.1.1")
}