import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("com.alexsobiek.terranova.java-common-conventions")
    `java-library`
}

val libs = the<LibrariesForLibs>()

dependencies {
    compileOnly(libs.bundles.logger)
    compileOnly(libs.gson)
}