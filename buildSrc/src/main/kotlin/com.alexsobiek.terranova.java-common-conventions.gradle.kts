import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    java
}

repositories {
    mavenCentral()
    maven("https://jitpack.io") {
        content {
            includeGroup("com.alexsobiek")
        }
    }
}

val libs = the<LibrariesForLibs>()

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    compileOnly(libs.bundles.nightconfig)
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}