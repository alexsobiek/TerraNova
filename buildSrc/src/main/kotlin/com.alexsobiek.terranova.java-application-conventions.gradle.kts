import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("com.alexsobiek.terranova.java-common-conventions")
    id("com.github.johnrengelman.shadow")
    application
}

val libs = the<LibrariesForLibs>()

dependencies {
    implementation(libs.bundles.logger)
    implementation(libs.gson)
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        minimize()
        archiveClassifier.set("dev")
        archiveBaseName.set("${project.name}-v${project.version}")
    }
}


tasks.named<JavaExec>("run") {
    val file = file(rootDir.path + "/run")
    file.mkdirs()
    workingDir = file
}

tasks.runShadow {
    val file = file(rootDir.path + "/run")
    file.mkdirs()
    workingDir = file
}

